package com.ginilab.tomafood.ui.main.login.repository

import com.ginilab.tomafood.ui.main.login.api.LoginApi
import com.ginilab.tomafood.ui.main.login.response.LoginBody
import com.ginilab.tomafood.ui.main.login.response.LoginResponse
import com.ginilab.tomafood.ui.main.login.response.SignUpResponse
import com.ginilab.tomafood.ui.main.login.response.UserDataSignUp
import kotlinx.coroutines.Deferred
import retrofit2.Response

class LoginRepositoryImpl(val loginApi: LoginApi) : LoginRepository {

    override fun getSignUpAsync(
        dataBody: UserDataSignUp
    ): Deferred<Response<SignUpResponse>> = loginApi.getSignUpAsync(dataBody)

    override fun getLoginAsync(logindataBody: LoginBody): Deferred<Response<LoginResponse>> = loginApi.getLoginAsync(logindataBody)
}