package com.ginilab.tomafood.ui.main

interface Location {

    fun getCurrentLocation(actName: String)

    fun getLat() : String

    fun getLon() : String

    fun openHomeFragment()

}