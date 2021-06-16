package com.example.mvvmEx.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {


    protected val TAG = javaClass.simpleName


    protected inline fun <reified T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> =
        lazy { DataBindingUtil.setContentView<T>(this@BaseActivity, resId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        super.onCreate(savedInstanceState)

        Timber.tag(TAG).e(" Activity Create ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(TAG).e(" Activity Destroy ")
    }
}
