package com.neds.otachallenge.repositories

import com.neds.otachallenge.JsonUtil
import com.neds.otachallenge.data.entities.Activity
import com.neds.otachallenge.data.entities.Level
import com.neds.otachallenge.data.local.MainPrefStore
import com.neds.otachallenge.data.remote.FakeDataService
import com.neds.otachallenge.data.repositories.MainRepository
import io.objectbox.Box
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainRepositoryTest {

    @Mock
    private lateinit var service: FakeDataService

    @Mock
    private lateinit var levelBox: Box<Level>

    @Mock
    private lateinit var activityBox: Box<Activity>

    @Mock
    private lateinit var prefStore: MainPrefStore

    private lateinit var repository: MainRepository
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockWebServer = MockWebServer()
        mockWebServer.start()
        repository = MainRepository(service, levelBox, activityBox, prefStore)
    }

    @Test
    fun getLevelsTest() {
        val responseJson = JsonUtil.readJsonFile("response.json")
        mockWebServer.enqueue(MockResponse().setBody(responseJson))

        repository.getLevels(false)
        verify(service).fetchDataFromJson()
    }
}