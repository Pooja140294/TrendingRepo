package com.ginilab.tomafood.ui.main.kishan.adapter

import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.ui.main.kishan.delegate.TrendingDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class TrendingAdapter(items: List<Cell>, cellListener: CellListener) :
    ListDelegationAdapter<List<Cell>>() {

    interface CellListener {
        fun onCellClick(cell: Cell)
    }

    init {
        delegatesManager.addDelegate(
            TrendingDelegate(
                cellListener
            )
        )
        setItems(items)
    }
}