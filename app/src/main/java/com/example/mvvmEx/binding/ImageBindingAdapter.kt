package com.example.mvvmEx.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


@BindingAdapter(value = ["loadImage", "loadImageProgress"], requireAll = false)
fun ImageView.loadImage(
    imagePath: String?,
    progress: ProgressBar? = null
) {
    progress?.visibility = View.VISIBLE
    Glide.with(this).load(imagePath)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progress?.visibility = View.INVISIBLE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progress?.visibility = View.INVISIBLE
                return false
            }

        }).into(this)
}
