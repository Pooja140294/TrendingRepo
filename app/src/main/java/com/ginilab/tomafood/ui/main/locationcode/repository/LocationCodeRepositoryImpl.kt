package com.ginilab.tomafood.ui.main.locationcode.repository

import com.ginilab.tomafood.ui.main.locationcode.api.LocationCodeApi
import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.ui.main.locationcode.response.PostCodeResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

class LocationCodeRepositoryImpl(private val codeApi: LocationCodeApi) : LocationCodeRepository {

    override fun getPostCodeListAsync(
        body: JsonPostCodeRequest
    ): Deferred<Response<PostCodeResponse>> = codeApi.getPostCodeAsync(body)


}