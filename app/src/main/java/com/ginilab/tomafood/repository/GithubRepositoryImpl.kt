package com.ginilab.tomafood.repository

import com.ginilab.tomafood.api.GithubApi
import com.ginilab.tomafood.model.TrendingResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {

    override fun getTrendingListAsync(
        language: String?,
        since: String?
    ): Deferred<Response<List<TrendingResponse>>> =
        githubApi.getTrendingListAsync(language, since)
}