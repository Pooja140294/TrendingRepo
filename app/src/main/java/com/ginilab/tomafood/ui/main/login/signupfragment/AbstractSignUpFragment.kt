package com.ginilab.tomafood.ui.main.login.signupfragment

import com.ginilab.tomafood.base.common.EventObserver
import com.ginilab.tomafood.base.core.BaseFragment
import com.ginilab.tomafood.base.extensions.showShortToast
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.ui.main.login.LoginViewModel
import com.ginilab.tomafood.ui.main.login.response.SignUpResponse
import com.ginilab.tomafood.ui.main.login.response.UserDataSignUp
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class AbstractSignUpFragment : BaseFragment<LoginViewModel>() {

    override val viewModel: LoginViewModel by sharedViewModel()

    fun fetchLoginData(dataBody: UserDataSignUp){

        showLoading(true)
        viewModel.getSignUpData(dataBody)
        getLoginData()
    }

    fun getLoginData(){
        viewModel.signUpLiveData.observe(viewLifecycleOwner, EventObserver{

            when(it){

                is DataState.Success -> {
                    setSignUpData(it.data)
                    activity!!.showShortToast(it.data.toString())

                }

                is DataState.Failure -> {
                    context?.showShortToast(it.errorMessage)

                }
            }
        })
    }

    abstract fun setSignUpData(data: SignUpResponse)

    abstract fun showLoadingState(state: Boolean)
}