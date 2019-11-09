package com.ginilab.tomafood.ui.main.locationcode.api

import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.ui.main.locationcode.response.PostCodeResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface LocationCodeApi {

    @POST("restaurant/postcode")
    fun getPostCodeAsync(@Body body: JsonPostCodeRequest) : Deferred<Response<PostCodeResponse>>

}