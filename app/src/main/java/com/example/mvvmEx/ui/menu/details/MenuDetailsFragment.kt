package com.example.mvvmEx.ui.menu.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mvvmEx.R
import com.example.mvvmEx.core.BaseFragment
import com.example.mvvmEx.databinding.MenuDetailsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuDetailsFragment :
    BaseFragment<MenuDetailsFragmentBinding>(R.layout.menu_details_fragment) {
    private val args: MenuDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            item = this@MenuDetailsFragment.args.Item
        }.root
    }


}