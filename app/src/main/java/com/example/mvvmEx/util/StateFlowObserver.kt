package com.example.baseproject.util

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull

object StateFlowObserver {
    fun <T : Any> flowObserver(
        scope: LifecycleCoroutineScope,
        flow: Flow<T?>,
        result: (T) -> Unit
    ) {
        scope.launchWhenStarted { flow.filterNotNull().collect { response -> result(response) } }
    }
}