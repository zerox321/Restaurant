package com.example.mvvmEx.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.datalayer.MenuItem
import com.example.mvvmEx.R
import com.example.mvvmEx.binding.bindListDecoration
import com.example.mvvmEx.core.BaseFragment
import com.example.mvvmEx.core.BaseResponse
import com.example.mvvmEx.databinding.FragmentMenuBinding
import com.example.mvvmEx.ui.menu.adapter.MenuAdapter
import com.example.mvvmEx.util.NavigationUtil.findNavigationController
import com.example.mvvmEx.util.NavigationUtil.navigateTo
import com.example.mvvmEx.util.StateFlowObserver.flowObserver
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding>(R.layout.fragment_menu),
    MenuAdapter.ClickListener {

    private val viewModel by viewModels<MenuViewModel>()
    private val menuAdapter: MenuAdapter = MenuAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            viewModel = this@MenuFragment.viewModel
            offerAdapter = this@MenuFragment.menuAdapter
            recyclerView.bindListDecoration(R.drawable.recycler_list_line_divider)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Todo observe Menu response
        flowObserver(
            scope = viewLifecycleOwner.lifecycleScope,
            flow = viewModel.response,
            result = { response ->
                when (response) {
                    is BaseResponse.Loading -> viewModel.setLoading(response.loading)
                    is BaseResponse.Success -> menuAdapter.submitList(response.data)
                    is BaseResponse.Error -> onError(response.throwable)
                }
            }
        )

    }

    private fun onError(throwable: Throwable) {


    }


    override fun onItemClick(v: View, item: MenuItem) {
        val args = Bundle().apply {
            putString("title", item.name)
            putParcelable("Item", item)
        }
        v.findNavigationController()
            .navigateTo(
                id = R.id.action_MenuFragment_to_OrderDetailsFragment,
                args = args
            )

    }


}