package com.ginilab.tomafood.base.ui

import android.graphics.Rect
import android.view.View
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView

class HomeBorderDecoration(@IntRange(from = 0) private val margin: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        val position = parent.getChildLayoutPosition(view)
        val lastItemPosition = parent.adapter?.itemCount ?: 1
        if (position != (lastItemPosition - 1))
            outRect.bottom = margin

    }
}