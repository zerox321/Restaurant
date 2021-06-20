package com.example.mvvmEx.binding

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mvvmEx.R
import com.facebook.shimmer.ShimmerFrameLayout



@BindingAdapter("bindShimmer")
fun ShimmerFrameLayout.bindShimmer(isLoading: Boolean) {
    visibility = if (isLoading) {
        startShimmer()
        View.VISIBLE
    } else {
        stopShimmer()
        View.GONE
    }

}

