package com.example.clockcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.clockcomposable.screens.MainScreen


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val initialTimeSeconds = 24_450L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(
                time = viewModel.clockDownTimer.collectAsState(initial = initialTimeSeconds).value
            )
        }
    }
}
