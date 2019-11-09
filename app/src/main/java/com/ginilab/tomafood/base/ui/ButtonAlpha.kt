/*
 * Copyright (C) PT SehatQ Harsana Emedika - All Rights Reserved
 */

package com.ginilab.tomafood.base.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Button
import com.ginilab.tomafood.R

class ButtonAlpha : Button {

    init {
        setBackgroundResource(R.drawable.bg_rounded_btn_state)
    }

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        /*if (isEnabled) {
            alpha = when (event?.action) {
                MotionEvent.ACTION_DOWN -> 0.5f
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> 1.0f
                else -> alpha
            }
        }*/
        return super.onTouchEvent(event)
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        //alpha = if (enabled) 1.0f else 0.5f
        if (enabled)
            if (Build.VERSION.SDK_INT < 23) {
                setTextColor(resources.getColor(R.color.white_default))

            } else {
                setTextColor(context.getColor(R.color.white_default))
            }
        else
            if (Build.VERSION.SDK_INT < 23) {
                setTextColor(resources.getColor(R.color.very_light_pink))

            } else {
                setTextColor(context.getColor(R.color.very_light_pink))
            }
    }
}