package com.neds.otachallenge.data.views

import android.graphics.drawable.Drawable
import com.neds.otachallenge.data.enums.ActivityState

data class ActivityView(
    val id: String,
    val challengeId: String,
    val type: String,
    val title: String,
    val description: String,
    val state: ActivityState,
    val icon: Drawable,
)