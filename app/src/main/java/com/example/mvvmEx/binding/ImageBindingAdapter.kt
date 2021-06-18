package com.example.mvvmEx.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.facebook.shimmer.ShimmerFrameLayout


@BindingAdapter(value = ["loadImage", "loadImageShimmer"], requireAll = false)
fun ImageView.loadImage(
    imagePath: String?,
    shimmer: ShimmerFrameLayout? = null
) {
    shimmer?.bindShimmer(isLoading = true)
    Glide.with(this).load(imagePath)
        .transition(DrawableTransitionOptions.withCrossFade())
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                shimmer?.bindShimmer(isLoading = false)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                shimmer?.bindShimmer(isLoading = false)
                return false
            }

        }).into(this)
}
