package com.example.mvvmEx.core

sealed class BaseResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : BaseResponse<T>()
    data class Error(val throwable: Throwable) : BaseResponse<Nothing>()
    data class Loading(val loading: Boolean) : BaseResponse<Nothing>()
    object None : BaseResponse<Nothing>()
}