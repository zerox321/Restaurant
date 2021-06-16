package com.example.mvvmEx.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.mvvmEx.R
import com.example.mvvmEx.core.BaseActivity
import com.example.mvvmEx.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
    }

    private fun bindView() {
        Timber.tag(TAG).e(" bindView start ")
        binding.run {
            setSupportActionBar(binding.toolbar)
            NavigationUI.setupWithNavController(toolbar, navController)
        }
    }

}