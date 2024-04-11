package com.neds.otachallenge.data.views

import com.neds.otachallenge.data.enums.ActivityType

data class ActivityView(
    val id: String,
    val challengeId: String,
    val type: ActivityType,
    val title: String,
    val description: String,
    val state: String,
    val icon: Int,
    val isCompleted: Boolean
)