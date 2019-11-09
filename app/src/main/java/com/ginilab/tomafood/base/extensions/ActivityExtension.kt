package com.ginilab.tomafood.base.extensions

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import com.ginilab.tomafood.base.helper.ApplicationUtil

fun AppCompatActivity.hideKeyboard() = ApplicationUtil.hideKeyboard(this)
fun AppCompatActivity.showKeyboard() = ApplicationUtil.showKeyboard(this)

fun getScreenHeight() = Resources.getSystem().displayMetrics.heightPixels
fun getScreenWidth() = Resources.getSystem().displayMetrics.widthPixels
