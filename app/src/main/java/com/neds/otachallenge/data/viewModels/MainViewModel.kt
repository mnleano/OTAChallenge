package com.neds.otachallenge.data.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.neds.otachallenge.data.repository.MainRepository

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    fun fetchDataFromJson() {
        Log.d("MainVm", "fetchDataFromJson")
        repository.fetchDataFromJson()
    }
}