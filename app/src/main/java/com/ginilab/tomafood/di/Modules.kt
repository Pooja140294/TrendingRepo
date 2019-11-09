package com.ginilab.tomafood.di

import com.ginilab.tomafood.base.retrofit.NetworkBuilder
import com.ginilab.tomafood.base.retrofit.NetworkBuilder.BASE_URL
import com.ginilab.tomafood.repository.GithubRepository
import com.ginilab.tomafood.repository.GithubRepositoryImpl
import com.ginilab.tomafood.ui.main.home.repository.HomeRepository
import com.ginilab.tomafood.ui.main.home.HomeViewModel
import com.ginilab.tomafood.ui.main.home.api.HomeApi
import com.ginilab.tomafood.ui.main.home.repository.HomeRepositoryImpl
import com.ginilab.tomafood.ui.main.kishan.MainViewModel
import com.ginilab.tomafood.ui.main.locationcode.UserLocationCodeViewModel
import com.ginilab.tomafood.ui.main.locationcode.api.LocationCodeApi
import com.ginilab.tomafood.ui.main.locationcode.repository.LocationCodeRepository
import com.ginilab.tomafood.ui.main.locationcode.repository.LocationCodeRepositoryImpl
import com.ginilab.tomafood.ui.main.login.api.LoginApi
import com.ginilab.tomafood.ui.main.login.LoginViewModel
import com.ginilab.tomafood.ui.main.login.repository.LoginRepository
import com.ginilab.tomafood.ui.main.login.repository.LoginRepositoryImpl
import com.ginilab.tomafood.ui.main.splash.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

object Modules {

    private val viewModelModules = module {
        viewModel { MainViewModel(get(), get()) }
        viewModel { SplashViewModel(get(), get()) }
        viewModel { UserLocationCodeViewModel(get(), get()) }
        viewModel { LoginViewModel(get(), get()) }
        viewModel { HomeViewModel(get(), get()) }
    }

    private val networkModules = module {
       /* single<GithubApi> {
            NetworkBuilder.create(androidApplication(), BASE_URL, GithubApi::class.java)
        }*/

        single<LocationCodeApi> {
            NetworkBuilder.create(androidApplication(), BASE_URL, LocationCodeApi::class.java)
        }

        single<LoginApi> {
            NetworkBuilder.create(androidApplication(), BASE_URL, LoginApi::class.java)
        }

        single<HomeApi> {
            NetworkBuilder.create(androidApplication(), BASE_URL, HomeApi::class.java)
        }
    }

    private val repoModules = module {
        single<GithubRepository> { GithubRepositoryImpl(get()) }
        single<LocationCodeRepository> { LocationCodeRepositoryImpl(get())  }
        single<LoginRepository> { LoginRepositoryImpl(get())  }
        single<HomeRepository> { HomeRepositoryImpl(get()) }
    }

    fun getAll() = listOf(
        viewModelModules,
        networkModules,
        repoModules
    )
}