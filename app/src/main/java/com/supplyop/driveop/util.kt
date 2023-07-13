package com.supplyop.driveop

import androidx.annotation.ColorInt
import com.google.android.material.snackbar.Snackbar

object util {

    fun Snackbar.withColor(@ColorInt colorInt: Int): Snackbar {
        this.view.setBackgroundColor(colorInt)
        return this
    }
}