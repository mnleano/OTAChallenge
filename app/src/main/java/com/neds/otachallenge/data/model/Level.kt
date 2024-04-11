package com.neds.otachallenge.data.model

import com.neds.otachallenge.data.enums.LevelState

data class Level(
    val level: Int,
    val title: String,
    val description: String,
    val state: LevelState,
    val activities: List<Activity>
)
