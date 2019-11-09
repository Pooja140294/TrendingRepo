package com.ginilab.tomafood.ui.main.login.repository

import com.ginilab.tomafood.ui.main.login.response.LoginBody
import com.ginilab.tomafood.ui.main.login.response.LoginResponse
import com.ginilab.tomafood.ui.main.login.response.SignUpResponse
import com.ginilab.tomafood.ui.main.login.response.UserDataSignUp
import kotlinx.coroutines.Deferred
import org.json.JSONObject
import retrofit2.Response

interface LoginRepository {

    fun getSignUpAsync(dataBody: UserDataSignUp) : Deferred<Response<SignUpResponse>>

    fun getLoginAsync(logindataBody: LoginBody) : Deferred<Response<LoginResponse>>
}