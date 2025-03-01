package ru.sulgik.mapkit.location

import kotlinx.datetime.Instant
import ru.sulgik.mapkit.geometry.Point

public data class Location(
    val position: Point,
    val accuracy: Double?,
    val altitude: Double?,
    val altitudeAccuracy: Double?,
    val heading: Double?,
    val speed: Double?,
    val indoorLevelId: String?,
    val absoluteTimestamp: Instant,
    val relativeTimestamp: Instant,
)
