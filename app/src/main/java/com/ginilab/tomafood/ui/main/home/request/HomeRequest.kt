package com.ginilab.tomafood.ui.main.home.request

import com.squareup.moshi.Json

class HomeRequest(
    @Json(name = "postcode") val postcode: String,
    @Json(name = "lastVisited") val lastVisited: List<Int>
    )