package com.njk.amphibians

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.njk.amphibians.network.Amphibian

// updates the shown in recycler view
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Amphibian>?){
    val adapter = recyclerView.adapter as AmphibianListAdapter
    adapter.submitList(data)
}
// TODO: Show error message via image