package com.supplyop.driveop.login.utils

import androidx.annotation.ColorInt
import com.google.android.material.snackbar.Snackbar

object Utils {

    fun Snackbar.withColor(@ColorInt colorInt: Int): Snackbar {
        this.view.setBackgroundColor(colorInt)
        return this
    }
}