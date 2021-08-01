package com.example.mvvmEx.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigator
import com.example.datalayer.model.MenuItem
import com.example.mvvmEx.R
import com.example.mvvmEx.core.BaseFragment
import com.example.mvvmEx.core.BaseResponse
import com.example.mvvmEx.databinding.FragmentMenuBinding
import com.example.mvvmEx.ui.menu.adapter.MenuAdapter
import com.example.mvvmEx.ui.menu.adapter.MenuClickListener
import com.example.mvvmEx.util.ErrorHandler.showError
import com.example.mvvmEx.util.NavigationUtil.navigateTo
import com.example.mvvmEx.util.StateFlowObserver.nonNullFlowObserver
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding>(R.layout.fragment_menu), MenuClickListener {

    private val viewModel by viewModels<MenuViewModel>()
    private val menuAdapter: MenuAdapter by lazy { MenuAdapter(clickListener = this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            viewModel = this@MenuFragment.viewModel
            recyclerView.adapter = this@MenuFragment.menuAdapter
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Todo observe Menu response
        nonNullFlowObserver(
            scope = viewLifecycleOwner.lifecycleScope,
            flow = viewModel.response,
            result = { response ->
                when (response) {
                    is BaseResponse.Loading -> viewModel.setLoading(response.loading)
                    is BaseResponse.Success -> onSuccess(response.data)
                    is BaseResponse.Error -> onError(response.throwable)
                }
            }
        )


    }

    private fun onSuccess(menuList: List<MenuItem>) {
        viewModel.setLoading(false)
        menuAdapter.submitList(menuList)
    }

    private fun onError(throwable: Throwable) {
        viewModel.setLoading(false)
        throwable.showError(context = context ?: return)
    }


    override fun onItemClick(item: MenuItem, extras: FragmentNavigator.Extras) {
        navigateTo(
            id = R.id.action_MenuFragment_to_OrderDetailsFragment,
            args = Bundle().apply {
                putString("title", item.name)
                putParcelable("menuItem", item)
            },
            extras = extras

        )

    }


}