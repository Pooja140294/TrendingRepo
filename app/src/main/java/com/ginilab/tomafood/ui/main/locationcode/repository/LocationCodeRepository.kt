package com.ginilab.tomafood.ui.main.locationcode.repository

import com.ginilab.tomafood.ui.main.locationcode.response.JsonPostCodeRequest
import com.ginilab.tomafood.ui.main.locationcode.response.PostCodeResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface LocationCodeRepository {

    fun getPostCodeListAsync(body: JsonPostCodeRequest) : Deferred<Response<PostCodeResponse>>

}