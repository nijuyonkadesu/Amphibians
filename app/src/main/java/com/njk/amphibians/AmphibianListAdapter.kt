package com.njk.amphibians

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.njk.amphibians.databinding.ItemBinding
import com.njk.amphibians.network.Amphibian

class AmphibianListAdapter(val clickListener: AmphibianListener): ListAdapter<Amphibian, > {
    class AmphibianViewHolder(
        val binding: ItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {

        }
}

class AmphibianListener(val clickListener: (amphibian: Amphibian) -> Unit) {
    fun onClick(amphibian: Amphibian) = clickListener(amphibian)
}