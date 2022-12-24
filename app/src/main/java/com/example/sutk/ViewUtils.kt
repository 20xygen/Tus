package com.example.sutk

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.TypedValue
import androidx.annotation.Nullable


object ViewUtils {
    fun getThemeAccentColor(context: Context): Int {
        val value = TypedValue()
        context.theme.resolveAttribute(com.google.android.material.R.color.accent_material_light, value, true)
        return value.data
    }

    fun updateDrawableColor(@Nullable drawable: Drawable?, color: Int) {
        if (drawable == null) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) drawable.setTint(color) else drawable.setColorFilter(
            color,
            PorterDuff.Mode.SRC_ATOP
        )
    }
}
