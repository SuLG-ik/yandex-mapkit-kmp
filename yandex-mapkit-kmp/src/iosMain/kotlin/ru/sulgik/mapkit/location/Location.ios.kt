package ru.sulgik.mapkit.location

import kotlinx.datetime.toKotlinInstant
import kotlinx.datetime.toNSDate
import platform.Foundation.NSDate
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toNSNumber
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import YandexMapKit.YMKLocation as NativeLocation

@OptIn(ExperimentalTime::class)
public fun Location.toNative(): NativeLocation {
    return NativeLocation.locationWithPosition(
        position = position.toNative(),
        accuracy = accuracy?.toNSNumber(),
        altitude = altitude?.toNSNumber(),
        altitudeAccuracy = altitudeAccuracy?.toNSNumber(),
        heading = heading?.toNSNumber(),
        speed = speed?.toNSNumber(),
        indoorLevelId = indoorLevelId,
        absoluteTimestamp = absoluteTimestamp.toNSDate(),
        relativeTimestamp = NSDate.dateWithTimeIntervalSince1970(
            relativeTimestamp.inWholeMilliseconds / 1000.0,
        ),
    )
}

@OptIn(ExperimentalTime::class)
public fun NativeLocation.toCommon(): Location {
    return Location(
        position = position.toCommon(),
        accuracy = accuracy?.doubleValue,
        altitude = altitude?.doubleValue,
        altitudeAccuracy = altitudeAccuracy?.doubleValue,
        heading = heading?.doubleValue,
        speed = speed?.doubleValue,
        indoorLevelId = indoorLevelId,
        absoluteTimestamp = absoluteTimestamp.toKotlinInstant(),
        relativeTimestamp = relativeTimestamp.timeIntervalSince1970.seconds,
    )
}
