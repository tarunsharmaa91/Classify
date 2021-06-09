package com.app.classify.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.classify.databinding.ViewItemBinding
import com.app.classify.ui.list.adapter.AdListAdapter.ListViewHolder
import com.app.classify.model.Results

class AdListAdapter(val onClickListener: OnClickListener) :
    ListAdapter<Results, ListViewHolder>(DiffCallback) {

    class ListViewHolder(private var binding: ViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ads: Results) {
            binding.listing = ads
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.uid == newItem.uid
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val results = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(results)
        }
        holder.bind(results)
    }

    class OnClickListener(val clickListener: (results: Results) -> Unit) {
        fun onClick(results: Results) = clickListener(results)
    }
}