package com.ginilab.tomafood.ui.main.login.response

import com.squareup.moshi.Json

/*{
    "status": true,
    "user": {
    "id": "216941",
    "usertype": "user",
    "firstname": "Rashed",
    "lastname": "Sumon",
    "postcode": null,
    "city": null,
    "address": null,
    "house": null,
    "homephone": null,
    "workphone": null,
    "mobilephone": "01727374744",
    "phone": "01727374744"
}
}*/
data class SignUpResponse(
    @Json(name = "status") val status: Boolean,
    @Json(name = "user") val user: User
)

data class User(
    @Json(name = "id") val id: String = "",
    @Json(name = "usertype") val usertype: String = "",
    @Json(name = "firstname") val firstname: String = "",
    @Json(name = "lastname") val lastname: String = "",
    @Json(name = "postcode") val postcode: String = "",
    @Json(name = "city") val city: String = "",
    @Json(name = "address") val address: String = "",
    @Json(name = "house") val house: String = "",
    @Json(name = "homephone") val homephone: String = "",
    @Json(name = "workphone") val workphone: String = "",
    @Json(name = "mobilephone") val mobilephone: String = "",
    @Json(name = "phone") val phone: String = ""
)