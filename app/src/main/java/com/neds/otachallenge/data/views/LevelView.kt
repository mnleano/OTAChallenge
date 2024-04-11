package com.neds.otachallenge.data.views

data class LevelView(
    val level: Int,
    val title: String,
    val description: String,
    val state: String,
    val activities: List<ActivityView>
)
