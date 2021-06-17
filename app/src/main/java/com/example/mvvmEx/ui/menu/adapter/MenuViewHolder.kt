package com.example.mvvmEx.ui.menu.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.datalayer.MenuItem
import com.example.mvvmEx.databinding.MenuRowItemBinding

class MenuViewHolder(
    private val binding: MenuRowItemBinding,
    private val clickListener: MenuClickListener?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MenuItem) {
        binding.item = item
        binding.clickListener = clickListener
    }
}
