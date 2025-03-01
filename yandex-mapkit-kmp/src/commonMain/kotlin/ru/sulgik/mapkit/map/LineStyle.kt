package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color

public data class LineStyle(
    val strokeWidth: Float = 5.0F,
    val gradientLength: Float = 0.0F,
    val outlineColor: Color = Color.fromArgb(0),
    val outlineWidth: Float = 0.0F,
    val innerOutlineEnabled: Boolean = false,
    val turnRadius: Float = 10.0F,
    val arcApproximationStep: Float = 12.0F,
    val dashLength: Float = 0.0F,
    val gapLength: Float = 0.0F,
    val dashOffset: Float = 0.0F
)
