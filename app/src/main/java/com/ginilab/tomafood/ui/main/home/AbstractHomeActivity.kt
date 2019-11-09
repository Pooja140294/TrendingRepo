package com.ginilab.tomafood.ui.main.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.ginilab.tomafood.base.common.EventObserver
import com.ginilab.tomafood.base.core.BaseActivity
import com.ginilab.tomafood.base.core.BaseFragment
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

abstract class AbstractHomeActivity  : BaseActivity<HomeViewModel>(){

    override val viewModel: HomeViewModel by viewModel()

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val LOCATION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    @SuppressLint("NewApi")
    fun fetchLocation(){
        showLoading(true)
        if (checkAndRequestPermissions()) {
            onLocationPermissionGranted()
        }
    }

    /**
     * This method will return true if all permission is granted
     * else return false
     * if True the load api call with lat long onLocationPermissionGranted()
     * if false then load api without lat long onLocationPermissionNotGranted()
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkAndRequestPermissions(): Boolean {
        val fineLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val coarseLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)

        val listPermissionsNeeded = ArrayList<String>()

        if (fineLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }
        if (coarseLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (listPermissionsNeeded.isNotEmpty()) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ), LOCATION_REQUEST_CODE
            )
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_REQUEST_CODE -> {
                val perms = HashMap<String, Int>()
                perms[Manifest.permission.ACCESS_FINE_LOCATION] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.ACCESS_COARSE_LOCATION] = PackageManager.PERMISSION_GRANTED

                /**
                 * Fill with actual results from user input
                 */
                if (grantResults.isNotEmpty()) {
                    for (i in permissions.indices)
                        perms[permissions[i]] = grantResults[i]
                }

                if (perms[Manifest.permission.ACCESS_FINE_LOCATION] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.ACCESS_COARSE_LOCATION] == PackageManager.PERMISSION_GRANTED)
                    onLocationPermissionGranted()
                else {
                    onLocationPermissionNotGranted()
                }

            }
        }
    }
    private fun onLocationPermissionGranted() {
        fusedLocationClient.lastLocation.addOnSuccessListener {
            if (it != null) {
                showLoading(false)
     //           viewModel.setLatitude(it.latitude)
     //           viewModel.setLongitude(it.longitude)
                Timber.d("Location Not Null !!")
                getAbstractLatLon(it.latitude, it.longitude)

            } else {
                Timber.d("Location Null!!")
            }
        }
    }

    abstract fun getAbstractLatLon(latitude: Double, longitude: Double)

    private fun onLocationPermissionNotGranted() {

        Timber.d("Location Permission not granted !!")
    }

    //fetch Post code using lat/long

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
                    getPostCode(it.data.postcode)
                    Timber.d("GET POST CODE RESPONSE = ${it.data}")

                }
                is DataState.Failure -> {
                    showLoading(false)

                }
            }
        })
    }

    abstract fun getPostCode(postcode: String)

}