package com.ginilab.tomafood.ui.main.locationcode.response

import com.squareup.moshi.Json

data class PostCodeResponse(
    @Json(name = "status") val status: Boolean,
    @Json(name = "postcode") val postcode: String
)