package com.ginilab.tomafood.ui.main.home.adapter

import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.ui.main.home.delegate.*
import com.ginilab.tomafood.ui.main.home.response.HomeResponse
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class HomeAdapter(items: List<Cell>, cellListener: CellListener = object :
    CellListener {}) : ListDelegationAdapter<List<Cell>>()  {


    interface CellListener {
        fun onCellClick(cell: Cell) {}
    }

    init {

        delegatesManager
            .addDelegate(Section1RecyclerDelegate(cellListener))
            .addDelegate(Section1ItemDelegate(cellListener))

            .addDelegate(Section2RecyclerDelegate(cellListener))
            .addDelegate(Section2ItemDelegate(cellListener))

            .addDelegate(Section3RecyclerDelegate(cellListener))
            .addDelegate(Section3ItemDelegate(cellListener))

            .addDelegate(Section4RecyclerDelegate(cellListener))
            .addDelegate(Section4ItemDelegate(cellListener))

            .addDelegate(Section5RecyclerDelegate(cellListener))
            .addDelegate(Section5ItemDelegate(cellListener))


        setItems(items)
    }

}