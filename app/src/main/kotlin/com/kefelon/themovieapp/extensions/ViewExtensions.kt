package com.kefelon.themovieapp.extensions

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.google.android.material.snackbar.Snackbar
import com.kefelon.themovieapp.BuildConfig
import com.kefelon.themovieapp.R

fun View.showSnackBar(text: String?, color: Int, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, text.toString(), length)
    snack.setTextColor(Color.WHITE)
    snack.view.background =
        ResourcesCompat.getDrawable(resources, R.drawable.background_rounded_corner_5dp, null)
    snack.view.background.colorFilter =
        BlendModeColorFilterCompat.createBlendModeColorFilterCompat(color, BlendModeCompat.SRC_ATOP)
    snack.show()
}

@BindingAdapter("loadImageUrl")
fun ImageView.loadImageUrl(url: String?) {
    if (!url.isNullOrEmpty()) {
        val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
        Glide.with(this.context).load("${BuildConfig.IMAGE_BASE_URL}$url")
            .transition(DrawableTransitionOptions.withCrossFade(factory))
            .diskCacheStrategy(DiskCacheStrategy.ALL).into(this)
    }
}