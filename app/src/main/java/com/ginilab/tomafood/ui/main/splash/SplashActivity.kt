package com.ginilab.tomafood.ui.main.splash

import android.content.Intent
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.ginilab.tomafood.R
import com.ginilab.tomafood.ui.main.home.HomeActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashActivity : AbstractSplashActivity() {

    override fun getLayoutRes(): Int = R.layout.activity_splash

    override val viewModel: SplashViewModel by viewModel()

    private val timeDelayed: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moveToWalkThroughActivity()
    }

    override fun moveToWalkThroughActivity() {
        launch {
            delay(timeDelayed)
            withContext(Dispatchers.Main){
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
            }
        }
    }

}
