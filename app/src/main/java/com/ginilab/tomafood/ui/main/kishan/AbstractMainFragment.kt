package com.ginilab.tomafood.ui.main.kishan

import android.view.View
import android.widget.EditText
import com.ginilab.tomafood.base.common.EventObserver
import com.ginilab.tomafood.base.core.BaseFragment
import com.ginilab.tomafood.base.extensions.showShortToast
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.model.TrendingResponse
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class AbstractMainFragment : BaseFragment<MainViewModel>() {

    override val viewModel: MainViewModel by sharedViewModel()

    override fun viewInitialization(view: View) {
        fetchData()
  //      observeDataChange()
    }

    fun fetchData(language: String?="java", since: String?="daily") {
//        viewModel.getTrendingData(language, since)
    }

  /*  private fun observeDataChange() {
        viewModel.trendingLiveData.observe(viewLifecycleOwner, EventObserver { trendingData ->
            when (trendingData) {
                is DataState.Success -> {
                    setTrendingData(trendingData.data)
                }
                is DataState.Failure -> {
                    context?.showShortToast(trendingData.errorMessage)
                }
            }
        })

        viewModel.loadingState.observe(viewLifecycleOwner, EventObserver{ showLoadingState(it) })
    }*/

   // abstract fun setTrendingData(list:List<TrendingResponse>)
   // abstract fun showLoadingState(loading:Boolean)
}