package com.njk.amphibians

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.njk.amphibians.databinding.ItemBinding
import com.njk.amphibians.network.Amphibian

class AmphibianListAdapter(private val clickListener: AmphibianListener):
    ListAdapter<Amphibian, AmphibianListAdapter.AmphibianViewHolder>(DiffCallback) {

    class AmphibianViewHolder(
        val binding: ItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(clickListener: AmphibianListener, amphibian: Amphibian){
                binding.amphibian = amphibian
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }

    companion object DiffCallback : DiffUtil.ItemCallback<Amphibian>() {

        override fun areItemsTheSame(oldItem: Amphibian, newItem: Amphibian): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Amphibian, newItem: Amphibian): Boolean {
            return oldItem.type == newItem.type && oldItem.description == newItem.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmphibianViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AmphibianViewHolder(
            ItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AmphibianViewHolder, position: Int) {
        val amphibian = getItem(position)
        holder.bind(clickListener, amphibian)
    }
}

class AmphibianListener(val clickListener: (amphibian: Amphibian) -> Unit) {
    fun onClick(amphibian: Amphibian) = clickListener(amphibian)
}