package com.neds.otachallenge.viewModels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.neds.otachallenge.data.repositories.MainRepository
import com.neds.otachallenge.data.viewModels.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MainRepository

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(repository)
    }

    @Test
    fun fetchLevelsTest() {
        viewModel.fetchLevels()
        verify(repository).getLevels(false)
    }
}