package com.ginilab.tomafood.ui.main.locationcode.response

import com.squareup.moshi.Json

data class JsonPostCodeRequest (
    @Json(name = "latitude") val latitude: String,
    @Json(name = "longitude") val longitude: String
    )