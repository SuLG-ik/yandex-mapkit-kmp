package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.geometry.Point
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * @property position The geographical position.
 * @property accuracy Location accuracy in meters.
 * @property altitude The altitude of the location in meters.
 * @property altitudeAccuracy The accuracy of the altitude in meters.
 * @property heading The current heading in degrees relative to true north, clockwise.
 * @property speed The speed in meters per second.
 * @property indoorLevelId The universal identifier of indoor level.
 * @property absoluteTimestamp Absolute timestamp, in milliseconds since January 1, 1970.
 * @property relativeTimestamp Time passed on steady clock. Use for interval calculation.
 */
@OptIn(ExperimentalTime::class)
public data class Location(
    val position: Point,
    val accuracy: Double?,
    val altitude: Double?,
    val altitudeAccuracy: Double?,
    val heading: Double?,
    val speed: Double?,
    val indoorLevelId: String?,
    val absoluteTimestamp: Instant,
    val relativeTimestamp: Duration,
)
