package com.ginilab.tomafood.ui.main.home.asklocation

import android.content.Context
import android.view.View
import android.widget.Button

import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.contract.FragmentNavigation
import com.ginilab.tomafood.ui.main.Location
import com.ginilab.tomafood.ui.main.locationcode.AbstractUserLocationCodeActivity
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.utils.IBottomBarAction


class AskLocationFragment : AbstractUserLocationCodeActivity(), FragmentNavigation {

    private lateinit var btn_loc : Button
    private lateinit var btn_code : Button
    private lateinit var lat: String
    private lateinit var lon: String
    private lateinit var locationListener: Location
    private lateinit var bottomBarListener: IBottomBarAction

    override fun navigateToHome(postcode: String) {

        locationListener.openHomeFragment()
       }

    override fun getLayoutRes(): Int = R.layout.fragment_ask_location

    override fun viewInitialization(view: View) {

        initView(view)
        setListener()
    }

    fun initView(view: View){

        btn_loc = view.findViewById(R.id.btn_location)
        btn_code = view.findViewById(R.id.btn_postcode)
    }

    fun setListener(){
        btn_loc.setOnClickListener{
            locationListener.getCurrentLocation("askLocationFragment")
        }
        btn_code.setOnClickListener{

        }
    }


    fun fetchPostCodeData(lat: String, lon: String){

        //fetchPostCode(JsonPostCodeRequest(lat.toString(), lon.toString()))
        fetchPostCode(JsonPostCodeRequest("54.9016", "-1.3895"))

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        locationListener = context as Location
        bottomBarListener = context as IBottomBarAction
        bottomBarListener.hideBottomBar()
    }

    override fun onDetach() {
        super.onDetach()
        bottomBarListener.showBottomBar()
    }
}

