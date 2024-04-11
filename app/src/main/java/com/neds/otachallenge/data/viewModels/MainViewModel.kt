package com.neds.otachallenge.data.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neds.otachallenge.data.repositories.MainRepository
import com.neds.otachallenge.data.views.LevelView

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    private val mLevels = MutableLiveData<List<LevelView>>()
    val levels: LiveData<List<LevelView>> = mLevels

    init {

    }

    fun fetchDataFromJson() {
        Log.d("MainVm", "fetchDataFromJson")
        repository.fetchDataFromJson()
    }
}