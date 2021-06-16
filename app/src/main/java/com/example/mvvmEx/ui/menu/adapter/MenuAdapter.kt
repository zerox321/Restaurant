package com.example.mvvmEx.ui.menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.datalayer.MenuItem
import com.example.mvvmEx.databinding.MenuRowItemBinding

class MenuAdapter(private val clickListener: ClickListener? = null) :
    ListAdapter<MenuItem, MenuAdapter.OfferAdapterViewHolder>(OfferResponseDataDC) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OfferAdapterViewHolder = OfferAdapterViewHolder(
        binding = MenuRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        clickListener = clickListener
    )


    override fun onBindViewHolder(holder: OfferAdapterViewHolder, position: Int) =
        holder.bind(getItem(position))


    inner class OfferAdapterViewHolder(
        private val binding: MenuRowItemBinding,
        private val clickListener: ClickListener?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MenuItem) {
            binding.item = item
            binding.clickListener = clickListener
        }
    }

    interface ClickListener {
        fun onItemClick(v: View, item: MenuItem)
    }

    private object OfferResponseDataDC : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(
            oldItem: MenuItem,
            newItem: MenuItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MenuItem,
            newItem: MenuItem
        ): Boolean {
            return oldItem == newItem

        }
    }
}