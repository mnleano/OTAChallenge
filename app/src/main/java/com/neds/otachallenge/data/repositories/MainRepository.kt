package com.neds.otachallenge.data.repositories

import com.neds.otachallenge.data.entities.Activity
import com.neds.otachallenge.data.entities.Activity_
import com.neds.otachallenge.data.entities.Level
import com.neds.otachallenge.data.local.MainPrefStore
import com.neds.otachallenge.data.maps.asEntity
import com.neds.otachallenge.data.maps.asView
import com.neds.otachallenge.data.remote.FakeDataService
import com.neds.otachallenge.data.views.LevelView
import io.objectbox.Box
import io.objectbox.query.QueryBuilder

class MainRepository(
    private val service: FakeDataService,
    private val levelBox: Box<Level>,
    private val activityBox: Box<Activity>,
    private val prefStore: MainPrefStore,
) {

    fun getLevels(isForced: Boolean): List<LevelView> {

        if (prefStore.shouldFetchLevel || levelBox.isEmpty || isForced) {
            val response = service.fetchDataFromJson()

            levelBox.removeAll()
            activityBox.removeAll()

            response?.levels?.forEach {
                val level = it.asEntity()
                levelBox.put(level)
                it.activities.forEach { activityDto ->
                    val activity = activityDto.asEntity(levelId = level.level)
                    activityBox.put(activity)
                }
            }
        }

        val levels = levelBox.all.map { level ->
            level.asView(activityBox.query().equal(
                Activity_.levelId,
                level.level.toString(),
                QueryBuilder.StringOrder.CASE_INSENSITIVE
            ).build().find().map { a -> a.asView() })
        }

        prefStore.levelLastTimeSaved = System.currentTimeMillis()
        return levels
    }
}