package com.example.mvvmEx.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected fun launchTask(task: suspend () -> Unit) = viewModelScope.launch(Dispatchers.Main) { task() }
}