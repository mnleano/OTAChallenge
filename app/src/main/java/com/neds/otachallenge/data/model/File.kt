package com.neds.otachallenge.data.model

data class File(
    val url: String,
    val details: Details,
    val fileName: String,
    val contentType: String
)