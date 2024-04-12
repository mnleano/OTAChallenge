package com.neds.otachallenge.data.model

data class ActivityDto(
    val id: String,
    val challengeId: String,
    val type: String,
    val title: String,
    val titleB: String?,
    val description: String,
    val descriptionB: String?,
    val state: String,
)