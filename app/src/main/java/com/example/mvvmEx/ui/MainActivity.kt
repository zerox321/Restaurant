package com.example.mvvmEx.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.mvvmEx.R
import com.example.mvvmEx.core.BaseActivity
import com.example.mvvmEx.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView()
    }

    private fun bindView() {
        Timber.tag(TAG).e(" bindView start ")
        binding.run {}
    }

}