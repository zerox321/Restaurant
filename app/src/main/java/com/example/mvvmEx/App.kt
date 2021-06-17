package com.example.mvvmEx

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    init {
        // support Legacy Drawable Resources
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate() {
        super.onCreate()
        //  logger in Debug Mode Only
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())

    }
}