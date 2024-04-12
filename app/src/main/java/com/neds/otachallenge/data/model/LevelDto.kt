package com.neds.otachallenge.data.model

data class LevelDto(
    val level: Int,
    val title: String,
    val description: String,
    val state: String,
    val activities: List<ActivityDto>
)
