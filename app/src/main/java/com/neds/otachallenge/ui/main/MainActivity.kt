package com.neds.otachallenge.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import com.neds.otachallenge.R
import com.neds.otachallenge.data.viewModels.MainViewModel
import com.neds.otachallenge.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val vm: MainViewModel by viewModel()

    private lateinit var adapter: LevelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        setupLevels()
        observeData()
    }

    private fun setupLevels() {
        adapter = LevelAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun observeData() {
        vm.levels.observe(this) {
            adapter.setLevels(it)
        }
    }

    override fun onResume() {
        super.onResume()
        vm.fetchLevels()
    }
}