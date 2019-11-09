package com.ginilab.tomafood.ui.main.locationcode

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ginilab.tomafood.base.common.Event
import com.ginilab.tomafood.base.core.BaseScopeViewModel
import com.ginilab.tomafood.base.extensions.awaitAndGet
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.base.model.Result
import com.ginilab.tomafood.ui.main.locationcode.repository.LocationCodeRepository
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.ui.main.locationcode.response.PostCodeResponse
import kotlinx.coroutines.launch
import timber.log.Timber

class UserLocationCodeViewModel(app: Application, private val codeRepo: LocationCodeRepository) : BaseScopeViewModel(app) {

    private var userLatitude: Double? = null
    private var userLongitude: Double? = null
    val loadingState = MutableLiveData<Event<Boolean>>()

    fun setLatitude(latitude: Double) {
        userLatitude = latitude
        Timber.d("Latitude!!$userLatitude")
    }

    fun setLongitude(latitude: Double) {
        userLongitude = latitude
        Timber.d("Longitude!!$userLongitude!!")
    }

    fun getLatitude(): Double? {
        return userLatitude
    }

    fun getLongitude(): Double? {
        return userLongitude
    }

    private val _codeMliveData by lazy { MutableLiveData<Event<DataState<PostCodeResponse>>>() }
    val codeLiveData : LiveData<Event<DataState<PostCodeResponse>>> by lazy { _codeMliveData }

    fun getPostCode(body: JsonPostCodeRequest){

        launch {

            loadingState.postValue(Event(true))

            when(val result = codeRepo.getPostCodeListAsync(body).awaitAndGet()){

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