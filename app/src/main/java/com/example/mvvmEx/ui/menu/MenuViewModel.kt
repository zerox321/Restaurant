package com.example.mvvmEx.ui.menu

import com.example.datalayer.model.MenuItem
import com.example.mvvmEx.core.BaseResponse
import com.example.mvvmEx.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(private val repo: MenuRepo) : BaseViewModel() {
    val response: StateFlow<BaseResponse<List<MenuItem>>?> = repo.response.asStateFlow()
    fun fetchMenuList() = launchTask { repo.getMenu() }

    init {
        fetchMenuList()
    }
}