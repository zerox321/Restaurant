package com.example.mvvmEx.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

abstract class BaseRepository {

    suspend fun <T : Any> buildApi(task: suspend () -> T) = flow<BaseResponse<T>> {
        emit(BaseResponse.Success(data = task()))
    }
        .flowOn(Dispatchers.IO)
        .onStart { emit(BaseResponse.Loading(loading = true)) }
        .catch { throwable -> emit(BaseResponse.Error(throwable = throwable)) }


}