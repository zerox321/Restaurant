package com.example.mvvmEx.ui.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.datalayer.model.MenuItem
import com.example.mvvmEx.databinding.MenuRowItemBinding

class MenuAdapter(private val clickListener: MenuClickListener? = null) :
    ListAdapter<MenuItem, MenuViewHolder>(MenuDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuViewHolder = MenuViewHolder(
        binding = MenuRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        clickListener = clickListener
    )


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) =
        holder.bind(getItem(position))


}