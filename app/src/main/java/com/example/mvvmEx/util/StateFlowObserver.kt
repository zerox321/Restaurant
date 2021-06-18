package com.example.mvvmEx.util

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

object StateFlowObserver {

    fun <T : Any> nonNullFlowObserver(
        scope: LifecycleCoroutineScope,
        flow: Flow<T?>,
        result: (T) -> Unit
    ) {
        scope.launch {
            flow.filterNotNull().collect { response -> result(response) }
        }
    }

}