package com.neds.otachallenge

import android.content.Context
import com.ddyos.flipper.mmkv.plugin.MMKVFlipperPlugin
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.soloader.SoLoader
import com.google.gson.Gson
import com.neds.otachallenge.data.entities.Activity
import com.neds.otachallenge.data.entities.Level
import com.neds.otachallenge.data.entities.MyObjectBox
import com.neds.otachallenge.data.local.LocalPreferences
import com.neds.otachallenge.data.local.MainPrefStore
import com.neds.otachallenge.data.remote.FakeDataService
import com.neds.otachallenge.data.repositories.MainRepository
import com.neds.otachallenge.data.viewModels.MainViewModel
import com.tencent.mmkv.MMKV
import io.objectbox.BoxStore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun initMmvk(context: Context): MMKV {
    MMKV.initialize(context)
    val mmkv = MMKV.defaultMMKV(MMKV.SINGLE_PROCESS_MODE, "TODO: key-for-encryption")!!
    SoLoader.init(context, false);
    if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(context)) {
        with(AndroidFlipperClient.getInstance(context)) {
            this.addPlugin(
                MMKVFlipperPlugin(
                    MMKV.defaultMMKV()!!.mmapID()
                )
            ) // mmkv viewer plugin supports
            this.start()
        }
    }
    return mmkv
}

val modules = module {

    single { Gson() }
    single { initMmvk(get()) }
    single { LocalPreferences(get(), get()) }
    factory { MainPrefStore(get()) }

    // Services
    single { FakeDataService(get(), get()) }

    // ViewModel
    viewModel { MainViewModel(get()) }

    // Repository
    single { MainRepository(get(), get(named("levelBox")), get(named("activityBox")), get()) }

    // ObjectBox
    single { MyObjectBox.builder().androidContext(get<Context>()).build() }
    single(named("levelBox")) { get<BoxStore>().boxFor(Level::class.java) }
    single(named("activityBox")) { get<BoxStore>().boxFor(Activity::class.java) }

}