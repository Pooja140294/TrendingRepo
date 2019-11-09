package com.ginilab.tomafood.ui.main.home.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.ui.main.home.adapter.HomeAdapter
import com.ginilab.tomafood.ui.main.home.response.Section1Restaurants
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.synthetic.main.test_landing.view.*


class Section1ItemDelegate(private val onClick: HomeAdapter.CellListener): AbsListItemAdapterDelegate<Section1Restaurants, Cell, Section1ItemDelegate.HomeListItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): HomeListItemHolder {

        return HomeListItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.test_landing,
                parent,
                false
            ), onClick
        )
    }

    override fun isForViewType(item: Cell, items: MutableList<Cell>, position: Int): Boolean {
        return item is Section1Restaurants
    }

    override fun onBindViewHolder(item: Section1Restaurants, holder: HomeListItemHolder, payloads: MutableList<Any>) {

        holder.bind(item)
    }

    class HomeListItemHolder(
        itemView: View,
        private val cellListener: HomeAdapter.CellListener
    ) : RecyclerView.ViewHolder(itemView){

        private val visiblePercentage = 0.9

        fun bind(listItem: Section1Restaurants){

            with(itemView){

                tv_titleName.text = listItem.restaurant_name
                tv_subtitleName.text = listItem.restaurant_type
                if (!listItem.rating.isNullOrEmpty()){
                    ratings.rating = listItem.rating.toFloat()
                    tv_rating.text = listItem.rating

                }

                tv_minorder.text = "No Minimum Order"
                tv_discount.text = "25% minimum discount on each order"

            }
        }
    }
}