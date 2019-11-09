package com.ginilab.tomafood.base.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager

abstract class BaseFragment<VM : BaseViewModel> : PlainFragment() {

    abstract override fun getLayoutRes(): Int

    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.doOnViewAttached()
    }

    /**
     * This method is called after view has been created.
     * This method should be used to initialize all views that are needed to be created (and recreated after fragment is reattached)
     * @param view The root view of the fragment
     */
    abstract override fun viewInitialization(view: View)


    protected fun showFailureDialog(title: String?, email: String, imageResource: Int){

    }

    fun showFailureDialog(title: String?, errorMessage: String, imageResource: Int, fragmentManager: FragmentManager){

    }
}