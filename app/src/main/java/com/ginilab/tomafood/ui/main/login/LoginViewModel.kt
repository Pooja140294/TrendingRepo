package com.ginilab.tomafood.ui.main.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ginilab.tomafood.base.common.Event
import com.ginilab.tomafood.base.core.BaseScopeViewModel
import com.ginilab.tomafood.base.extensions.awaitAndGet
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.base.model.Result
import com.ginilab.tomafood.ui.main.login.repository.LoginRepository
import com.ginilab.tomafood.ui.main.login.response.LoginBody
import com.ginilab.tomafood.ui.main.login.response.LoginResponse
import com.ginilab.tomafood.ui.main.login.response.SignUpResponse
import com.ginilab.tomafood.ui.main.login.response.UserDataSignUp
import kotlinx.coroutines.launch

class LoginViewModel(app : Application, private val loginRepo: LoginRepository) : BaseScopeViewModel(app) {

    val loadingState = MutableLiveData<Event<Boolean>>()

    //signUp
    private val _signUpMLiveData by lazy { MutableLiveData<Event<DataState<SignUpResponse>>>() }
    val signUpLiveData : LiveData<Event<DataState<SignUpResponse>>> by lazy { _signUpMLiveData }

  //  fun getSignUpData(dataBody: UserDataSignUp){
        fun getSignUpData(dataBody: UserDataSignUp){

        launch {

            when(val result = loginRepo.getSignUpAsync(dataBody).awaitAndGet()){

                is Result.Success -> {
                    loadingState.postValue(Event(false))
                    result.body?.let {
                        Event(DataState.Success(it))
                    }.run( _signUpMLiveData :: postValue )
                }

                is Result.Failure -> {
                    loadingState.postValue(Event(false))

                }

            }
        }
    }

    //login

    private val _loginMLiveData by lazy { MutableLiveData<Event<DataState<LoginResponse>>>() }
    val _loginLiveData : LiveData<Event<DataState<LoginResponse>>> by lazy { _loginMLiveData }

    fun getLoginData(dataBody: LoginBody){

        launch {

            when(val result = loginRepo.getLoginAsync(dataBody).awaitAndGet()){

                is Result.Success ->{
                    loadingState.postValue(Event(false))
                    result.body?.let {
                        Event(DataState.Success(it))
                    }.run(_loginMLiveData :: postValue )

                }

                is Result.Failure ->{
                    loadingState.postValue(Event(false))

                }
            }
        }
    }

}