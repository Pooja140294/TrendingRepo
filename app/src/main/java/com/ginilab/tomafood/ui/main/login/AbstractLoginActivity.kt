package com.ginilab.tomafood.ui.main.login

import com.ginilab.tomafood.base.core.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class AbstractLoginActivity: BaseActivity<LoginViewModel>()  {

    override val viewModel: LoginViewModel by viewModel()



}