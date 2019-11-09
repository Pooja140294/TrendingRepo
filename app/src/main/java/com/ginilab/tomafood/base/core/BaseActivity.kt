package com.ginilab.tomafood.base.core


abstract class BaseActivity<VM : BaseViewModel> : PlainActivity() {

    abstract val viewModel: VM

}