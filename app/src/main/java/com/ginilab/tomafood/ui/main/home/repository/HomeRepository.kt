package com.ginilab.tomafood.ui.main.home.repository

import com.ginilab.tomafood.ui.main.home.request.HomeRequest
import com.ginilab.tomafood.ui.main.home.response.HomeResponse
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.ui.main.locationcode.response.PostCodeResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface HomeRepository {

    fun getHomeAsync(dataBody: HomeRequest) : Deferred<Response<HomeResponse>>

    fun getPostCodeListAsync(body: JsonPostCodeRequest) : Deferred<Response<PostCodeResponse>>

}