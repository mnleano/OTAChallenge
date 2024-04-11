package com.neds.otachallenge.data.views

import com.neds.otachallenge.data.enums.LevelState

data class LevelView(
    val level: Int,
    val title: String,
    val description: String,
    val state: LevelState,
    val activities: List<ActivityView>
)
