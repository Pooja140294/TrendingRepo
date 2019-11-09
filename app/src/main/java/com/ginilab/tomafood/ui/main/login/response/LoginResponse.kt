package com.ginilab.tomafood.ui.main.login.response

import com.squareup.moshi.Json

/*{
    "status": false,
    "message": "Username and/or password doesn't match"
}*/
data class LoginResponse (
    @Json(name = "status") val status: Boolean,
    @Json(name = "message") val message: String
)