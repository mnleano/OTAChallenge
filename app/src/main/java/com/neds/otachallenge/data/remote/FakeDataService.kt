package com.neds.otachallenge.data.remote

import android.content.Context
import com.google.gson.Gson
import com.neds.otachallenge.data.model.LevelsDto
import java.io.IOException


private const val RESPONSE_JSON = "response.json"
class FakeDataService(private val context: Context, private val gson: Gson) {

    fun fetchDataFromJson(): LevelsDto? {
        val json: String?
        try {
            val inputStream = context.assets.open(RESPONSE_JSON)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return gson.fromJson(json, LevelsDto::class.java)
    }
}