package com.example.clockcomposable.screens

import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color as ComposeColor
import com.example.clockcomposable.styles.ClockStyle
import com.example.clockcomposable.styles.HatchType
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun Clock(
    modifier: Modifier = Modifier,
    clockStyle: ClockStyle = ClockStyle(),
    initialTimeSeconds: Long = 23_452L
) {
    Canvas(
        modifier = modifier.fillMaxWidth()
    ) {
        val radius = clockStyle.radius.toPx()

        drawContext.canvas.nativeCanvas.drawCircle(
            center.x,
            center.y,
            radius,
            Paint().apply {
                color = Color.WHITE
                setShadowLayer(
                    60f,
                    0f,
                    0f,
                    Color.argb(50, 0, 0, 0)
                )
            }
        )

        for (i in 0..59) {
            val hatchType = when {
                i % 5 == 0 -> HatchType.MainHatch
                else -> HatchType.NormalHatch
            }
            val hatchColor = when(hatchType) {
                HatchType.MainHatch -> clockStyle.mainHatchColor
                HatchType.NormalHatch -> clockStyle.normalHatchColor
            }
            val hatchHeight = when(hatchType) {
                HatchType.MainHatch -> clockStyle.mainHatchHeight
                HatchType.NormalHatch -> clockStyle.normalHatchHeight
            }

            val angel = (360 / 60f) * i * (PI.toFloat() / 180)
            val startPoint = Offset(
                (radius - hatchHeight.toPx()) * cos(angel) + center.x,
                (radius - hatchHeight.toPx()) * sin(angel) + center.y
            )
            val endPoint = Offset(
                radius * cos(angel) + center.x,
                radius * sin(angel) + center.y
            )

            drawLine(
                hatchColor,
                startPoint,
                endPoint,
                clockStyle.hatchWidth.toPx()
            )
        }

        val seconds = initialTimeSeconds % 60
        val minutes = initialTimeSeconds / 60 % 60 + (seconds / 60f)
        val hours = initialTimeSeconds / 3600 % 12 + (minutes / 60f)

        val secondsAngel = ((360 / 60) * seconds - 90) * (PI.toFloat() / 180)
        val minutesAngel = ((360 / 60) * minutes - 90) * (PI.toFloat() / 180)
        val hoursAngel = ((360 / 12) * hours - 90) * (PI.toFloat() / 180)

        drawLine(
            clockStyle.secondStrokeColor,
            Offset(center.x, center.y),
            Offset(
                (radius - clockStyle.mainHatchHeight.toPx()) * cos(secondsAngel) + center.x,
                (radius - clockStyle.mainHatchHeight.toPx()) * sin(secondsAngel) + center.y
            ),
            clockStyle.secondStrokeWidth.toPx()
        )
        drawLine(
            ComposeColor.Black,
            Offset(center.x, center.y),
            Offset(
                (radius - clockStyle.mainHatchHeight.toPx()) * cos(minutesAngel) + center.x,
                (radius - clockStyle.mainHatchHeight.toPx()) * sin(minutesAngel) + center.y
            ),
            clockStyle.minuteStrokeWidth.toPx()
        )
        drawLine(
            ComposeColor.Black,
            Offset(center.x, center.y),
            Offset(
                clockStyle.hourStrokeLength.toPx() * cos(hoursAngel) + center.x,
                clockStyle.hourStrokeLength.toPx() * sin(hoursAngel) + center.y
            ),
            clockStyle.hourStrokeWidth.toPx()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClockPreview() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Clock(modifier = Modifier.align(Alignment.Center))
    }
}