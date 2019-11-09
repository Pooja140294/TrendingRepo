package com.ginilab.tomafood.ui.main.locationcode

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.ginilab.tomafood.base.common.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.ginilab.tomafood.base.core.BaseActivity
import com.ginilab.tomafood.base.core.BaseFragment
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import timber.log.Timber

abstract class AbstractUserLocationCodeActivity : BaseFragment<UserLocationCodeViewModel>() {

    override val viewModel: UserLocationCodeViewModel by viewModel()


    fun fetchPostCode(body: JsonPostCodeRequest){

   //     viewModel.getPostCode(latitude, longitude)
        viewModel.getPostCode(body)
        setCodeObserver()
        showLoading(true)
    }

    private fun setCodeObserver() {

        viewModel.codeLiveData.observe(this, EventObserver {
            when (it) {
                is DataState.Success -> {
                    showLoading(false)
                 //   prepareData(it.data)
                    navigateToHome(it.data.postcode)
                    Timber.d("GET POST CODE RESPONSE = ${it.data}")


                }
                is DataState.Failure -> {
                //    context?.showShortToast(it.errorMessage)
                    showLoading(false)

                }
            }
        })
    }

    abstract fun navigateToHome(postcode: String)
    }