package com.ginilab.tomafood.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.contract.FragmentNavigation
import com.ginilab.tomafood.base.core.BaseActivity
import com.ginilab.tomafood.ui.main.Location
import com.ginilab.tomafood.ui.main.home.asklocation.AskLocationFragment
import com.ginilab.tomafood.ui.main.home.homefragment.HomeFragment
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.utils.IBottomBarAction
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AbstractHomeActivity(), FragmentNavigation, IBottomBarAction, Location {

    private lateinit var lat: String
    private lateinit var lon: String
    private var openLocationFragment: Boolean = false
    private lateinit var askFragment : AskLocationFragment
    private lateinit var homeFragment : HomeFragment
    private lateinit var activityName: String

    override fun getLayoutRes(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            homeFragment = HomeFragment()
            askFragment = AskLocationFragment()

            if (openLocationFragment){
                startWithClearBackStack(this, R.id.fragmentHomeLayout, homeFragment)
                openLocationFragment = true
            }else{
                startWithClearBackStack(this, R.id.fragmentHomeLayout, askFragment)
            }
        }

        bnvHome.itemIconTintList = null

    }


    override fun onBackPressed() {

        /* val currentFragment = supportFragmentManager.findFragmentByTag(PromoDetailFragment.TAG)
         if (currentFragment != null) {
             (currentFragment as PromoDetailFragment).handleBackClick()
         } else {*/
        val count = supportFragmentManager.backStackEntryCount
        when {
            count != 0 -> supportFragmentManager.popBackStack()
            else -> super.onBackPressed()
        }
        //   }
    }

    override fun hideBottomBar() {

        bnvHome.visibility = View.GONE

    }

    override fun showBottomBar() {

        bnvHome.visibility = View.VISIBLE

    }

    override fun getAbstractLatLon(latitude: Double, longitude: Double) {

        lat = latitude.toString()
        lon = longitude.toString()

        //the below code is done to access the method of fragment from an activity
        /*if(askFragment != null){
            askFragment.fetchPostCodeData(lat,lon)
        }*/

        fetchPostCode(JsonPostCodeRequest("54.9016", "-1.3895"))
    }

   /* override fun getLocation(actName: String) {

        activityName = actName
        fetchLocation()

    }*/

    override fun getLat(): String {

        if (lat.isNullOrEmpty()){
            return ""
        }else {
            return lat
        }

    }

    override fun getLon() : String{

        if (lon.isNullOrEmpty()){
            return ""
        }else {
            return lon
        }

    }

    override fun getPostCode(postcode: String) {

        if(askFragment != null && activityName.equals("askLocationFragment")){
            askFragment.navigateToHome(postcode)
        }

        if (homeFragment != null  && activityName.equals("homeFragment")){
            homeFragment.fetchHomeData(postcode)
        }
    }

    override fun openHomeFragment(){
        startWithClearBackStack(this, R.id.fragmentHomeLayout, homeFragment)
    }


    //getLocation
    override fun getCurrentLocation(actName: String) {
        activityName = actName
        fetchLocation()
    }

}
