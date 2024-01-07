package com.example.clockcomposable.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    time: Long = 24_450L
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Clock(
            modifier = modifier.align(Alignment.Center),
            initialTimeSeconds = time
        )
    }
}



@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
