package com.ginilab.tomafood.api

import com.ginilab.tomafood.model.TrendingResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("repositories")
    fun getTrendingListAsync(
        @Query("language") language: String?=null,
        @Query("since") since: String?="daily"
    ): Deferred<Response<List<TrendingResponse>>>

}