package com.example.mvvmEx.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

abstract class BaseRepository {


    private val defaultDispatcher = Dispatchers.IO
    suspend fun <T : Any> buildApi(task: suspend () -> T) = flow<BaseResponse<T>> {
        emit(BaseResponse.Success(data = task()))
    }
        .flowOn(defaultDispatcher)
        .onStart { emit(BaseResponse.Loading(loading = true)) }
        .onCompletion { emit(BaseResponse.Loading(loading = false)) }
        .catch { throwable ->
            BaseResponse.Error(throwable = throwable)
        }


}