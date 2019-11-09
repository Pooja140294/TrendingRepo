package com.ginilab.tomafood.base.core

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.extensions.getColorFromRes
import timber.log.Timber

abstract class PlainFragment : Fragment() {

    open fun lightColorIcon(): Boolean = false

    @LayoutRes
    abstract fun getLayoutRes() : Int

    @ColorRes
    open fun statusBarColor(): Int = R.color.default_status_bar_color

    fun fragmentTag() : String = this::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeStatusBarColor()
        changeStatusBarIconColor()
        viewInitialization(view)
        onPreparationFinished(view)
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(fragmentTag()).d("fragment on pause")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(fragmentTag()).d("fragment on start")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(fragmentTag()).d("fragment on stop")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(fragmentTag()).d("fragment on resume")
    }

    protected fun showLoading(isShow : Boolean){
        (activity as PlainActivity?)?.showLoading(isShow)
    }


    fun changeStatusBarColor(@ColorRes barColor: Int = statusBarColor()) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return
        activity?.window?.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor().let { statusBarColor = context.getColorFromRes(barColor) }
        }
    }

    private fun changeStatusBarIconColor() {
        activity?.window?.decorView?.rootView?.systemUiVisibility =
            if (lightColorIcon()) 0 else 8192
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

    open fun onPreparationFinished(view: View){}


}