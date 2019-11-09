package com.ginilab.tomafood.ui.main.home.homefragment

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.base.contract.FragmentNavigation
import com.ginilab.tomafood.base.extensions.dipToPixels
import com.ginilab.tomafood.base.ui.HomeBorderDecoration
import com.ginilab.tomafood.ui.main.Location
import com.ginilab.tomafood.ui.main.home.adapter.HomeAdapter
import com.ginilab.tomafood.ui.main.home.request.HomeRequest
import com.ginilab.tomafood.utils.IBottomBarAction


class HomeFragment : AbstractHomeFragment(), FragmentNavigation, HomeAdapter.CellListener {

    private lateinit var iv_search: AppCompatImageView
    private lateinit var iv_location: ImageView
    private lateinit var et_search: EditText
    private lateinit var rv_home: RecyclerView
    private lateinit var isAdapter: HomeAdapter
    private lateinit var bottomBarListener: IBottomBarAction
    private lateinit var locationListener: Location

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun viewInitialization(view: View) {

        initViews(view)
        setClickListener()
        fetchHomeData("SR2 7AD")
       }

    private fun initViews(view: View) {

        iv_search = view.findViewById(R.id.iv_search)
        iv_location = view.findViewById(R.id.iv_location)
        et_search = view.findViewById(R.id.et_search)
        rv_home = view.findViewById(R.id.rv_home)

        isAdapter = HomeAdapter(listOf(), this)

        with(rv_home)
        {
            adapter = isAdapter
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())
            addItemDecoration(HomeBorderDecoration(requireContext().dipToPixels(10f)))
        }
    }

    private fun setClickListener() {

        iv_search.setOnClickListener{

            locationListener.getCurrentLocation("homeFragment")
        }
    }

        override fun getDataResponse(
        dataBody: List<Cell>
    ) {

        isAdapter.run {
            items = dataBody
            notifyDataSetChanged()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        locationListener = context as Location
        bottomBarListener = context as IBottomBarAction
        bottomBarListener.showBottomBar()
    }

    override fun onDetach() {
        super.onDetach()
        bottomBarListener.showBottomBar()
    }

    fun fetchHomeData(postCode: String){

        val lastVisitedList: MutableList<Int> = mutableListOf()
        lastVisitedList.add(0)
        fetchHomeData(HomeRequest("SR2 7AD", lastVisitedList ))

    }


}
