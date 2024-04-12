package com.neds.otachallenge

import java.io.IOException

object JsonUtil {
    fun readJsonFile(fileName: String): String {
        val inputStream = this::class.java.classLoader?.getResourceAsStream(fileName)
        return try {
            inputStream?.bufferedReader()?.use { it.readText() } ?: ""
        } catch (ex: IOException) {
            ex.printStackTrace()
            ""
        }
    }
}