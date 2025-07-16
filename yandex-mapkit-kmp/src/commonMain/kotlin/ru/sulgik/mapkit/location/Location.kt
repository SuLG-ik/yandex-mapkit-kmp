package ru.sulgik.mapkit.location

import kotlinx.datetime.Instant
import ru.sulgik.mapkit.geometry.Point
import kotlin.time.ExperimentalTime

public data class Location @OptIn(ExperimentalTime::class) constructor(
    val position: Point,
    val accuracy: Double?,
    val altitude: Double?,
    val altitudeAccuracy: Double?,
    val heading: Double?,
    val speed: Double?,
    val absoluteTimestamp: Instant,
    val relativeTimestamp: Instant,
)
