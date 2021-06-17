package com.example.mvvmEx.ui.menu.adapter

import android.view.View
import com.example.datalayer.MenuItem

interface MenuClickListener {
    fun onItemClick(v: View, item: MenuItem)
}