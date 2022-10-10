package com.kefelon.themovieapp.extensions

import android.graphics.Color
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.google.android.material.snackbar.Snackbar
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