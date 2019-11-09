package com.ginilab.tomafood.ui.main.login.loginfragment

import com.ginilab.tomafood.base.common.EventObserver
import com.ginilab.tomafood.base.core.BaseFragment
import com.ginilab.tomafood.base.extensions.showShortToast
import com.ginilab.tomafood.base.model.DataState
import com.ginilab.tomafood.ui.main.login.LoginViewModel
import com.ginilab.tomafood.ui.main.login.response.LoginBody
import com.ginilab.tomafood.ui.main.login.response.LoginResponse
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class AbstractLoginFragment : BaseFragment<LoginViewModel>() {

    override val viewModel: LoginViewModel by sharedViewModel()

    fun fetchLoginData(body: LoginBody){

        showLoading(true)
        viewModel.getLoginData(body)
        getLoginData()
    }

    fun getLoginData(){

        viewModel._loginLiveData.observe(viewLifecycleOwner, EventObserver{

            when(it){

                is DataState.Success ->{

                    setLoginData(it.data)
                }

                is DataState.Failure ->{
                    context?.showShortToast(it.errorMessage)
                }
            }
        })
    }

    abstract fun setLoginData(data: LoginResponse)
}