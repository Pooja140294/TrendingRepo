package com.ginilab.tomafood.ui.main.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.base.common.Event
import com.ginilab.tomafood.base.core.BaseScopeViewModel
import com.ginilab.tomafood.base.extensions.awaitAndGet
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.base.model.Result
import com.ginilab.tomafood.ui.main.home.cell.*
import com.ginilab.tomafood.ui.main.home.repository.HomeRepository
import com.ginilab.tomafood.ui.main.home.request.HomeRequest
import com.ginilab.tomafood.ui.main.home.response.HomeResponse
import com.ginilab.tomafood.ui.main.home.response.Listing
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.ui.main.locationcode.response.PostCodeResponse
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel (app : Application, private val homenRepo: HomeRepository) : BaseScopeViewModel(app) {

    var loadingState = MutableLiveData<Event<Boolean>>()

    //home
    private val homeMLiveData by lazy { MutableLiveData<DataState<HomeResponse>>() }
    val _homeLiveData : LiveData<DataState<HomeResponse>> by lazy { homeMLiveData }

    fun getHomeData(dataBody: HomeRequest){

        launch {

            when(val result = homenRepo.getHomeAsync(dataBody).awaitAndGet()){

                is Result.Success ->{

                    loadingState.postValue(Event(false))
                    result.body?.let {

                        DataState.Success(it)

                    }.run(homeMLiveData :: postValue)
                }

                is Result.Failure ->{
                    loadingState.postValue(Event(false))
                }
            }
        }
    }

    //fetch post code using lat/lon

    private val _codeMliveData by lazy { MutableLiveData<Event<DataState<PostCodeResponse>>>() }
    val codeLiveData : LiveData<Event<DataState<PostCodeResponse>>> by lazy { _codeMliveData }

    fun getPostCode(body: JsonPostCodeRequest){

        launch {

            loadingState.postValue(Event(true))

            when(val result = homenRepo.getPostCodeListAsync(body).awaitAndGet()){

                is Result.Success ->{
                    loadingState.postValue(Event(false))
                    result.body?.let {
                        Event(DataState.Success(it))
                    }.run(_codeMliveData :: postValue )
                }

                is Result.Failure ->{
                    loadingState.postValue(Event(false))

                }
            }
        }

    }
}