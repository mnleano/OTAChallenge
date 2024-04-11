package com.neds.otachallenge

import com.neds.otachallenge.data.repository.MainRepository
import com.neds.otachallenge.data.viewModels.MainViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private fun initMoshi() = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val modules = module {

    single { initMoshi() }

    // ViewModel
    viewModel { MainViewModel(get()) }

    // Repository
    single { MainRepository(get(), get()) }
}