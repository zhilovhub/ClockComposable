package com.example.clockcomposable.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ClockStyle(
    val radius: Dp = 110.dp,
    val hatchWidth: Dp = 1.dp,
    val normalHatchHeight: Dp = 14.dp,
    val normalHatchColor: Color = Color.LightGray,
    val mainHatchHeight: Dp = 21.dp,
    val mainHatchColor: Color = Color.Black,
    val secondStrokeWidth: Dp = 2.dp,
    val minuteStrokeWidth: Dp = 3.dp,
    val hourStrokeWidth: Dp = 4.dp,
    val secondStrokeColor: Color = Color.Red,
    val hourStrokeLength: Dp = 70.dp
)
