package com.ginilab.tomafood.ui.main.home.api

import com.ginilab.tomafood.ui.main.home.request.HomeRequest
import com.ginilab.tomafood.ui.main.home.response.HomeResponse
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.ui.main.locationcode.response.PostCodeResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeApi {

    @POST("restaurant/home/list")
    fun getHomeAsync(@Body dataBody: HomeRequest) : Deferred<Response<HomeResponse>>

    @POST("restaurant/postcode")
    fun getPostCodeAsync(@Body body: JsonPostCodeRequest) : Deferred<Response<PostCodeResponse>>

}