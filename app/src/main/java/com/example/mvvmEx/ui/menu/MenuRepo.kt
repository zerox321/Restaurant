package com.example.mvvmEx.ui.menu

import com.example.datalayer.model.MenuItem
import com.example.domainlayer.remote.MenuService
import com.example.mvvmEx.core.BaseRepository
import com.example.mvvmEx.core.BaseResponse
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import javax.inject.Inject

@ViewModelScoped
class MenuRepo @Inject constructor(private val menuService: MenuService) : BaseRepository() {

    val response = MutableStateFlow<BaseResponse<List<MenuItem>>?>(null)

    suspend fun getMenu() = response.emitAll(flow = buildApi { menuService.getMenu() })


}