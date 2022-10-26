package com.njk.amphibians

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.njk.amphibians.databinding.FragmentAmphibiansBinding
import com.njk.amphibians.model.AmphibianViewModel


class AmphibianListFragment : Fragment() {

    private var _binding: FragmentAmphibiansBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val sharedViewModel: AmphibianViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAmphibiansBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner // make UI observable
            recyclerView.adapter = AmphibianListAdapter(AmphibianListener { amphibian ->
                sharedViewModel.onAmphibianClicked(amphibian)
                findNavController().navigate(R.id.action_AmphibiansFragment_to_amphibianDetailFragment)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}