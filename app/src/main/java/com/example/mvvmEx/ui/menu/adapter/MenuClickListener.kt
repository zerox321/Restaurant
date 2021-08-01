package com.example.mvvmEx.ui.menu.adapter

import android.os.Bundle
import androidx.navigation.fragment.FragmentNavigator
import com.example.datalayer.model.MenuItem

interface MenuClickListener {
    fun onItemClick(extras: FragmentNavigator.Extras, args: Bundle)
}