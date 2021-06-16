package com.example.mvvmEx.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected val TAG: String = javaClass.simpleName

    private val defaultDispatcher = Dispatchers.Main
    private val defaultScope = viewModelScope
    protected fun launchTask(task: suspend () -> Unit) =
        defaultScope.launch(defaultDispatcher) { task() }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading
    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }


}