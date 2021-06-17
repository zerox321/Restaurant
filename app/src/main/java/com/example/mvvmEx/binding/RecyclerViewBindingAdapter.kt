package com.example.mvvmEx.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.mvvmEx.R

@BindingAdapter("bindSwipeRefreshLayoutColor")
fun SwipeRefreshLayout.bindSwipeRefreshLayoutColor(attach: Boolean?) {
    val c1 = ContextCompat.getColor(context, R.color.purple_200)
    val c2 = ContextCompat.getColor(context, R.color.purple_500)
    val c3 = ContextCompat.getColor(context, R.color.purple_700)

    val c4 = ContextCompat.getColor(context, R.color.teal_200)
    val c5 = ContextCompat.getColor(context, R.color.teal_700)
    setColorSchemeColors(c1, c2, c3, c4, c5)
}

@BindingAdapter("bindListDecoration")
fun RecyclerView.bindListDecoration(drawableRes: Int) {
    val drawable = ContextCompat.getDrawable(context, drawableRes) ?: return
    val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
    divider.setDrawable(drawable)
    addItemDecoration(divider)

}

