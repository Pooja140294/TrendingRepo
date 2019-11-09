package com.ginilab.tomafood.base.core

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.ginilab.tomafood.base.extensions.getColorFromRes
import com.ginilab.tomafood.base.extensions.hideKeyboard
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment<VM: ViewModel> : BottomSheetDialogFragment(){

    @LayoutRes
    abstract fun getLayoutRes(): Int

    open fun isDialogCancelable(): Boolean = true

    @ColorRes
    open fun statusBarColor(): Int? = null

    open fun lightColorIcon(): Boolean = false

    abstract val viewModel: VM

    fun fragmentTag(): String = this::class.java.simpleName

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (view!!.parent.parent.parent as View).fitsSystemWindows = true

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : BottomSheetDialog(context!!, theme) {
            override fun onBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    super.onBackPressed()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        KeyboardUtil(activity as FragmentActivity, view)
        isCancelable = isDialogCancelable()
//        changeStatusBarColor()
        changeStatusBarIconColor()
        viewInitialization(view)
        onPreparationFinished(view)
    }

    override fun onDestroyView() {
        (activity as AppCompatActivity?)?.hideKeyboard()
        super.onDestroyView()
    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return
        activity?.window?.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor()?.let { color -> statusBarColor = context.getColorFromRes(color) }
        }
    }

    private fun changeStatusBarIconColor() {
        activity?.window?.decorView?.rootView?.systemUiVisibility =
            if (lightColorIcon()) 0 else 8192
    }

    protected fun showLoading(isShow: Boolean) {
        (activity as BaseActivity<*>?)?.showLoading(isShow)
    }

    /**
     * This method is called after view has been created.
     * This method should be used to initialize all views that are needed to be created (and recreated after fragment is reattached)
     * @param view The root view of the fragment
     */
    open fun viewInitialization(view: View) {}

    /**
     * This method is called after viewInitialization(view) is finished
     * @param view The root view of the fragment
     */
    open fun onPreparationFinished(view: View) {}
}