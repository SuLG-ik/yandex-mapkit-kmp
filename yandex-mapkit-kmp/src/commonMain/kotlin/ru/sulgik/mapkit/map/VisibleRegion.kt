package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

public data class VisibleRegion(
    val topLeft: Point,
    val topRight: Point,
    val bottomLeft: Point,
    val bottomRight: Point,
)