package com.ginilab.tomafood.base.core

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.extensions.hideKeyboard
import com.ginilab.tomafood.progress.PageLoadingProgress
import timber.log.Timber

abstract class PlainActivity : AppCompatActivity() {

    protected val loadingDialog by lazy { PageLoadingProgress(this)  }
    val TAG by lazy { this::class.java.simpleName }

    @LayoutRes
    abstract fun getLayoutRes() : Int

    @ColorRes
    open fun statusBarColor(): Int = R.color.default_status_bar_color

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(TAG).d("Activity on start")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.tag(TAG).d("Activity on restart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(TAG).d("Activity on resume")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(TAG).d("Activity on stop")
    }

    @SuppressWarnings("InlinedApi", "newApi")
    private fun changeStatusBarColor(){
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = getColorFromRes(statusBarColor())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(TAG).d("Activity on destroy")
        hideKeyboard()
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(TAG).d("Activity on pause")
    }


    protected fun Context.getColorFromRes(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)

    override fun onBackPressed() {
        Timber.tag(TAG).d("Activity on back pressed")
        if (!loadingDialog.isVisible(this)) super.onBackPressed()
    }

    fun showLoading(isShow: Boolean){

        if (isShow){
            with(loadingDialog){

                showFromActivity(this@PlainActivity)
                requestFocus()
            }
            hideKeyboard()
        }else{
            loadingDialog.hideFromActivity(this)
        }
    }
}