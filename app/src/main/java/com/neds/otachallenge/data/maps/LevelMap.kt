package com.neds.otachallenge.data.maps

import com.neds.otachallenge.R
import com.neds.otachallenge.data.entities.Activity
import com.neds.otachallenge.data.entities.Level
import com.neds.otachallenge.data.enums.ActivityType
import com.neds.otachallenge.data.enums.LevelState
import com.neds.otachallenge.data.model.ActivityDto
import com.neds.otachallenge.data.model.LevelDto
import com.neds.otachallenge.data.views.ActivityView
import com.neds.otachallenge.data.views.LevelView
import kotlin.random.Random

fun ActivityDto.asEntity(id: Long = 0, levelId: Int) = Activity(
    id, levelId.toString(), this.id, challengeId, type, title, description, state
)

fun Activity.asView() = ActivityView(
    activityId,
    challengeId,
    ActivityType[type],
    title,
    description,
    state,
    getDrawable(),
    Random.nextBoolean()
)

fun LevelDto.asEntity(id: Long = 0) = Level(
    id, level, title, description, state
)

fun Level.asView(activities: List<ActivityView>) =
    LevelView(level, title, description, LevelState[state], activities)

fun getDrawable(): Int {
    val drawables =
        listOf(R.drawable.img_activity, R.drawable.img_activity2, R.drawable.img_activity3)
    return drawables.random()
}