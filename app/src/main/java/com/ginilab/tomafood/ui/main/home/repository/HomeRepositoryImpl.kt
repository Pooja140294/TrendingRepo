package com.ginilab.tomafood.ui.main.home.repository

import com.ginilab.tomafood.ui.main.home.api.HomeApi
import com.ginilab.tomafood.ui.main.home.request.HomeRequest
import com.ginilab.tomafood.ui.main.home.response.HomeResponse
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.ui.main.locationcode.response.PostCodeResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

class HomeRepositoryImpl(private val homeApi: HomeApi) : HomeRepository {

    override fun getHomeAsync(dataBody: HomeRequest): Deferred<Response<HomeResponse>> = homeApi.getHomeAsync(dataBody)

    override fun getPostCodeListAsync(
        body: JsonPostCodeRequest
    ): Deferred<Response<PostCodeResponse>> = homeApi.getPostCodeAsync(body)

}