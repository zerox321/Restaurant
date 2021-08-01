package com.example.mvvmEx.ui.menu.adapter

import android.os.Bundle
import androidx.navigation.fragment.FragmentNavigator

interface MenuClickListener {
    fun onItemClick(args: Bundle, extras: FragmentNavigator.Extras)
}