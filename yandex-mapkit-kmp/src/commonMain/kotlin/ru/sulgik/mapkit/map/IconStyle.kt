package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.PointF

public data class IconStyle(
    val anchor: PointF? = null,
    val rotationType: RotationType? = RotationType.NO_ROTATION,
    val zIndex: Float? = null,
    val flat: Boolean? = false,
    val isVisible: Boolean? = true,
    val scale: Float? = 1f,
    val tappableArea: Rect? = null,
)