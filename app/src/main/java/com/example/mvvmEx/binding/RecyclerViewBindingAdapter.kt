package com.example.mvvmEx.binding

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mvvmEx.R
import com.facebook.shimmer.ShimmerFrameLayout

@BindingAdapter("bindSwipeRefreshLayoutColor")
fun SwipeRefreshLayout.bindSwipeRefreshLayoutColor(attach: Boolean?) {
    val c1 = ContextCompat.getColor(context, R.color.purple_200)
    val c2 = ContextCompat.getColor(context, R.color.purple_500)
    val c3 = ContextCompat.getColor(context, R.color.purple_700)

    val c4 = ContextCompat.getColor(context, R.color.teal_200)
    val c5 = ContextCompat.getColor(context, R.color.teal_700)
    setColorSchemeColors(c1, c2, c3, c4, c5)
}

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

