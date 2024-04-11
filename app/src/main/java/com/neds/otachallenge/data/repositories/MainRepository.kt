package com.neds.otachallenge.data.repositories

import android.content.Context
import com.neds.otachallenge.data.maps.asView
import com.neds.otachallenge.data.model.Response
import com.neds.otachallenge.data.views.LevelView
import com.squareup.moshi.Moshi
import java.io.IOException

private const val RESPONSE_JSON = "response.json"

class MainRepository(private val context: Context, private val moshi: Moshi) {


    fun getLevels(): List<LevelView>? {
        val response = fetchDataFromJson()
        val levels = response?.levels?.map { level ->
            level.asView(level.activities.map { activity -> activity.asView() })
        }

        return levels
    }

    fun fetchDataFromJson(): Response? {
        val json: String?
        try {
            val inputStream = context.assets.open(RESPONSE_JSON)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        val adapter = moshi.adapter(Response::class.java)
        return adapter.fromJson(json)
    }
}