package com.neds.otachallenge.data.maps

import com.neds.otachallenge.R
import com.neds.otachallenge.data.enums.ActivityType
import com.neds.otachallenge.data.enums.LevelState
import com.neds.otachallenge.data.model.Activity
import com.neds.otachallenge.data.model.Level
import com.neds.otachallenge.data.views.ActivityView
import com.neds.otachallenge.data.views.LevelView
import kotlin.random.Random

fun Activity.asView() = ActivityView(
    id,
    challengeId,
    ActivityType[type],
    title,
    description,
    state,
    getDrawable(),
    Random.nextBoolean()
)

fun Level.asView(activities: List<ActivityView>) =
    LevelView(level, title, description, LevelState[state], activities)

fun getDrawable(): Int {
    val drawables =
        listOf(R.drawable.img_activity, R.drawable.img_activity2, R.drawable.img_activity3)
    return drawables.random()
}