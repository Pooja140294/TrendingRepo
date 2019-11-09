package com.ginilab.tomafood.ui.main.login.response

import com.squareup.moshi.Json

data class LoginBody (
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
    )