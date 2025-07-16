package ru.sulgik.mapkit.location

import kotlinx.datetime.Instant
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import kotlin.time.ExperimentalTime
import com.yandex.mapkit.location.Location as NativeLocation

@OptIn(ExperimentalTime::class)
public fun Location.toNative(): NativeLocation {
    return NativeLocation(
        position.toNative(),
        accuracy,
        altitude,
        altitudeAccuracy,
        heading,
        speed,
        absoluteTimestamp.toEpochMilliseconds(),
        relativeTimestamp.toEpochMilliseconds(),
    )
}

@OptIn(ExperimentalTime::class)
public fun NativeLocation.toCommon(): Location {
    return Location(
        position = position.toCommon(),
        accuracy = accuracy,
        altitude = altitude,
        altitudeAccuracy = altitudeAccuracy,
        heading = heading,
        speed = speed,
        absoluteTimestamp = Instant.fromEpochMilliseconds(absoluteTimestamp),
        relativeTimestamp = Instant.fromEpochMilliseconds(relativeTimestamp),
    )
}