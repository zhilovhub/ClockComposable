package com.example.clockcomposable

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn

class MainViewModel : ViewModel() {

    val clockDownTimer = flow {
        var currentTime = 0L

        emit(currentTime)
        while (true) {
            delay(1000L)
            currentTime += 1
            emit(currentTime)
        }
    }

    init {
        clockDownTimer.launchIn(viewModelScope)
    }

}