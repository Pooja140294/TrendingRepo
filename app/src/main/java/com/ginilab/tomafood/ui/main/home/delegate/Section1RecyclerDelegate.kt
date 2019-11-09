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
import com.ginilab.tomafood.ui.main.home.cell.HomeSection1ItemCell
import com.ginilab.tomafood.ui.main.home.response.HomeResponse
import com.ginilab.tomafood.ui.main.home.response.Section1
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.synthetic.main.layout_recycler_view.view.*

class Section1RecyclerDelegate(
    private val onClick: HomeAdapter.CellListener
): AbsListItemAdapterDelegate<HomeSection1ItemCell, Cell, Section1RecyclerDelegate.HomeRecyclerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): HomeRecyclerHolder {

        return HomeRecyclerHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_recycler_view,
                parent,
                false
            ), onClick
        )
    }

    override fun isForViewType(item: Cell, items: MutableList<Cell>, position: Int): Boolean {
        return item is HomeSection1ItemCell
    }

    override fun onBindViewHolder(item: HomeSection1ItemCell, holder: HomeRecyclerHolder, payloads: MutableList<Any>) {

        holder.bind(item)
    }

    class HomeRecyclerHolder(
        itemView: View,
        private val cellListener: HomeAdapter.CellListener
    ) : RecyclerView.ViewHolder(itemView){

        private val visiblePercentage = 0.9

        fun bind(listItem: HomeSection1ItemCell){

            with(itemView){

                txt_title.text = listItem.title
                if (!listItem.description.isNullOrEmpty()){
                    txt_subtitle.text = listItem.description
                }

                recyclerView.adapter = HomeAdapter(listItem.section1List, cellListener)

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