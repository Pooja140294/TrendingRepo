package com.ginilab.tomafood.ui.main.home.homefragment

import androidx.lifecycle.Observer
import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.base.core.BaseFragment
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.ui.main.home.HomeViewModel
import com.ginilab.tomafood.ui.main.home.cell.*
import com.ginilab.tomafood.ui.main.home.request.HomeRequest
import com.ginilab.tomafood.ui.main.home.response.HomeResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class AbstractHomeFragment : BaseFragment<HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModel()
    private var dataItem: MutableList<Cell> = mutableListOf()


    fun fetchHomeData(dataBody: HomeRequest){
        showLoading(true)
        viewModel.getHomeData(dataBody)
        getHomeData()
    }

    fun getHomeData(){

        viewModel._homeLiveData.observe(viewLifecycleOwner, Observer {

            when(it){

                is DataState.Success ->{

                    showLoading(false)

            //        dataItem.addAll(it.data)
                    getDataResponse(prepareData(it.data))

                }

                is DataState.Failure ->{


                }
            }
        })
    }


    fun prepareData(listData: HomeResponse): List<Cell>{

        val homeList: MutableList<Cell> = mutableListOf()

        if (!listData.listing.section_1.restaurants.isNullOrEmpty()) {
            homeList.add(
                HomeSection1ItemCell(listData.listing.section_1.restaurants, listData.listing.section_1.title, listData.listing.section_1.description)
            )
        }

        if (!listData.listing.section_2.restaurants.isNullOrEmpty()) {
            homeList.add(
                HomeSection2ItemCell(listData.listing.section_2.restaurants, listData.listing.section_2.title, listData.listing.section_2.description)
            )
        }

        if (!listData.listing.section_3.restaurants.isNullOrEmpty()) {
            homeList.add(
                HomeSection3ItemCell(listData.listing.section_3.restaurants, listData.listing.section_3.title, listData.listing.section_3.description)
            )
        }
        if (!listData.listing.section_4.restaurants.isNullOrEmpty()) {
            homeList.add(
                HomeSection4ItemCell(listData.listing.section_4.restaurants, listData.listing.section_4.title, listData.listing.section_4.description)
            )
        }

        if (!listData.listing.section_5.restaurants.isNullOrEmpty()) {
            homeList.add(
                HomeSection5ItemCell(listData.listing.section_5.restaurants, listData.listing.section_5.title, listData.listing.section_5.description)
            )
        }
        return homeList
    }

    abstract fun getDataResponse(
        dataBody: List<Cell>
    )
}