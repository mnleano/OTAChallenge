package com.neds.otachallenge.data.repository

import android.content.Context
import com.neds.otachallenge.data.model.Response
import com.squareup.moshi.Moshi
import java.io.IOException

private const val RESPONSE_JSON = "response.json"
class MainRepository(private val context: Context, private val moshi: Moshi) {



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