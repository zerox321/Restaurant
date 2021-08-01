package com.example.mvvmEx.ui.menu.adapter

import androidx.navigation.fragment.FragmentNavigator
import com.example.datalayer.model.MenuItem

interface MenuClickListener {
    fun onItemClick(item: MenuItem, extras: FragmentNavigator.Extras)
}