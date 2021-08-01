package com.example.mvvmEx.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.datalayer.model.MenuItem
import com.example.mvvmEx.core.BaseResponse
import com.example.mvvmEx.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(private val repo: MenuRepo) : BaseViewModel() {

    val response: StateFlow<BaseResponse<List<MenuItem>>> = repo.response.asStateFlow()


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading
    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    private fun fetchMenuList() = launchTask { repo.getMenu() }

    init {
        fetchMenuList()
    }
}