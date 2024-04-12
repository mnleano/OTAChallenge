package com.neds.otachallenge

import android.app.Application
import com.tencent.mmkv.BuildConfig
import io.objectbox.BoxStore
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    lateinit var boxStore: BoxStore
        private set


    override fun onCreate() {
        super.onCreate()

//        boxStore = MyObjectBox.builder().androidContext(this).build()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}