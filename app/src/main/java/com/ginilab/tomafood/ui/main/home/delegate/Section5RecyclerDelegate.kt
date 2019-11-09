package com.ginilab.tomafood.ui.main.home.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.base.extensions.getScreenWidth
import com.ginilab.tomafood.ui.main.home.adapter.HomeAdapter
import com.ginilab.tomafood.ui.main.home.cell.HomeSection5ItemCell
import com.ginilab.tomafood.ui.main.home.response.HomeResponse
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.synthetic.main.layout_recycler_view.view.*

class Section5RecyclerDelegate(private val onClick: HomeAdapter.CellListener):
    AbsListItemAdapterDelegate<HomeSection5ItemCell, Cell, Section5RecyclerDelegate.Section5RecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): Section5RecyclerHolder {

        return Section5RecyclerHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_recycler_view,
                parent,
                false
            ), onClick
        )
    }

    override fun isForViewType(item: Cell, items: MutableList<Cell>, position: Int): Boolean {
        return item is HomeSection5ItemCell
    }

    override fun onBindViewHolder(
        item: HomeSection5ItemCell,
        holder: Section5RecyclerHolder,
        payloads: MutableList<Any>
    ) {

    }

    class Section5RecyclerHolder(
        itemView: View,
        private val cellListener: HomeAdapter.CellListener
    ) : RecyclerView.ViewHolder(itemView){

        private val visiblePercentage = 0.9

        fun bind(listItem: HomeSection5ItemCell){

            with(itemView){

                txt_title.text = listItem.title
                txt_subtitle.text = listItem.description

                recyclerView.adapter = HomeAdapter(listItem.section5List, cellListener)

                recyclerView.layoutManager = object : LinearLayoutManager(
                    context,
                    HORIZONTAL, false
                ) {
                    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                        lp.width = (getScreenWidth() * visiblePercentage).toInt()
                        return true
                    }
                }
            }
        }
    }
}