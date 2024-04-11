package com.neds.otachallenge.data.maps

import com.neds.otachallenge.R
import com.neds.otachallenge.data.enums.ActivityType
import com.neds.otachallenge.data.enums.LevelState
import com.neds.otachallenge.data.model.Activity
import com.neds.otachallenge.data.model.Level
import com.neds.otachallenge.data.views.ActivityView
import com.neds.otachallenge.data.views.LevelView

fun Activity.asView() = ActivityView(
    id, challengeId, ActivityType[type], title, description, state, R.drawable.img_activity
)

fun Level.asView(activities: List<ActivityView>) =
    LevelView(level, title, description, LevelState[state], activities)