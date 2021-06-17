package com.example.mvvmEx.ui.menu.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.datalayer.MenuItem

object MenuDiffCallback : DiffUtil.ItemCallback<MenuItem>() {
    override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean =
        oldItem == newItem
}

