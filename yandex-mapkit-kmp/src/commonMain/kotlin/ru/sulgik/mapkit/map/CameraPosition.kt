package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

public data class CameraPosition(
    val target: Point,
    val zoom: Float,
    val azimuth: Float,
    val tilt: Float,
)
