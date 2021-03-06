package com.example.mvvmEx.ui.menu.adapter

import android.os.Bundle
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.datalayer.model.MenuItem
import com.example.mvvmEx.databinding.MenuRowItemBinding

class MenuViewHolder(
    private val binding: MenuRowItemBinding,
    private val clickListener: MenuClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MenuItem) {
        binding.item = item
        binding.root.setOnClickListener {
            clickListener.onItemClick(
                args = Bundle().apply {
                    putString("title", item.name)
                    putParcelable("menuItem", item)
                },
                extras = FragmentNavigatorExtras(
                    binding.ImageView to item.getImageSharedElementAnimation(),
                    binding.titleTv to item.getNameSharedElementAnimation()
                )
            )
        }
    }
}
