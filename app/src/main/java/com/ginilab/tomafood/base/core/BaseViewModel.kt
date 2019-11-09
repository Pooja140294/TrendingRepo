package com.ginilab.tomafood.base.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import kotlinx.coroutines.*
import java.lang.ref.WeakReference
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(private val app: Application) : AndroidViewModel(app) {

    //for internet connection
    private val connectionLiveData = ConnectionLiveData(WeakReference(app))

    private val connectionObserver = Observer<Boolean> { isConnected ->
        onConnectedToNetwork(isConnected)
    }

    init {
        connectionLiveData.observeForever(connectionObserver)
    }

    open fun doOnViewAttached() {}

    open fun onConnectedToNetwork(isConnected: Boolean) {}

    override fun onCleared() {
        super.onCleared()
        connectionLiveData.removeObserver(connectionObserver)
    }


}