package com.ginilab.tomafood.ui.main.login.response

import com.squareup.moshi.Json

data class UserDataSignUp(
    @Json(name = "user_data") val user_data: SignUp
)

data class SignUp(
    @Json(name = "firstname") val firstname: String,
    @Json(name = "lastname") val lastname: String,
    @Json(name = "email") val email: String,
    @Json(name = "mobilephone") val mobilephone: String,
    @Json(name = "password") val password: String)