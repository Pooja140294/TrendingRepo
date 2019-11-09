package com.ginilab.tomafood.ui.main.login.api

import com.ginilab.tomafood.ui.main.login.response.LoginBody
import com.ginilab.tomafood.ui.main.login.response.LoginResponse
import com.ginilab.tomafood.ui.main.login.response.SignUpResponse
import com.ginilab.tomafood.ui.main.login.response.UserDataSignUp
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("user/register")
    fun getSignUpAsync(@Body dataBody: UserDataSignUp) : Deferred<Response<SignUpResponse>>

    @POST("user/login")
    fun getLoginAsync(@Body dataBody: LoginBody) : Deferred<Response<LoginResponse>>
}