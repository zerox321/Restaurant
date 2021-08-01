package com.example.mvvmEx.util

import android.content.Context
import android.widget.Toast
import com.example.mvvmEx.BuildConfig
import com.example.mvvmEx.R

object ErrorHandler {
    fun Throwable.showError(context: Context) {
        val errorMessage = if (BuildConfig.DEBUG) "$message"
        else context.getString(R.string.no_internet)
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }
}