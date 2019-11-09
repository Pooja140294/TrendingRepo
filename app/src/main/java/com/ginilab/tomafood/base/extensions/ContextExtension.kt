package com.ginilab.tomafood.base.extensions


import android.content.Context
import android.util.TypedValue
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat


fun Context.showLongToast(str: String) = Toast.makeText(this, str, Toast.LENGTH_LONG).show()

fun Context.showShortToast(str: String) =  Toast.makeText(this, str, Toast.LENGTH_SHORT).show()

fun Context.getColorFromRes(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)

fun Context.getPixelDimenFromRes(@DimenRes res: Int) = resources.getDimension(res)

fun Context.dipToPixels(dipValue: Float): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, resources.displayMetrics).toInt()
