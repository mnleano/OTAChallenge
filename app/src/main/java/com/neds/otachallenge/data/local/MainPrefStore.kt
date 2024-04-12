package com.neds.otachallenge.data.local

import com.neds.otachallenge.BuildConfig

private const val KEY_LEVEL_LAST_TIME_SAVED = "LevelLastSaved"
class MainPrefStore(private val prefs: LocalPreferences) {

    var levelLastTimeSaved: Long
        get() = prefs.getLong(KEY_LEVEL_LAST_TIME_SAVED, 0)
        set(value) = prefs.putLong(KEY_LEVEL_LAST_TIME_SAVED, value)

    val shouldFetchLevel: Boolean
        get() = levelLastTimeSaved == 0L || System.currentTimeMillis() - levelLastTimeSaved > BuildConfig.FETCH_DELAY

    fun clear(){
        levelLastTimeSaved = 0
    }

}