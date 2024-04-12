package com.neds.otachallenge.data.entities

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Activity(
    @Id var id: Long = 0,
    val levelId: String,
    val activityId: String,
    val challengeId: String,
    val type: String,
    val title: String,
    val description: String,
    val state: String,
)