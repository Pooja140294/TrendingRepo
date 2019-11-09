package com.ginilab.tomafood.ui.main.kishan

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ginilab.tomafood.base.common.Event
import com.ginilab.tomafood.base.core.BaseScopeViewModel
import com.ginilab.tomafood.base.extensions.awaitAndGet
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.model.TrendingResponse
import com.ginilab.tomafood.base.model.Result
import com.ginilab.tomafood.repository.GithubRepository
import kotlinx.coroutines.launch

class MainViewModel(app: Application, private val githubRepo: GithubRepository) :
    BaseScopeViewModel(app) {


    private val _trendingLiveData by lazy { MutableLiveData<Event<DataState<List<TrendingResponse>>>>() }
    val trendingLiveData: LiveData<Event<DataState<List<TrendingResponse>>>> by lazy { _trendingLiveData }

    var loadingState = MutableLiveData<Event<Boolean>>()


    fun getTrendingData(language: String?, since: String?) {
        launch {
            loadingState.postValue(Event(true))
            when (val result = githubRepo.getTrendingListAsync(language, since).awaitAndGet()) {
                is Result.Success -> {
                    loadingState.postValue(Event(false))
                    result.body?.let {
                        Event(DataState.Success(it))
                    }.run(_trendingLiveData::postValue)
                }

                is Result.Failure -> {
                    loadingState.postValue(Event(false))
                }
            }
        }
    }

}
