package ru.sulgik.mapkit.directions.driving

import ru.sulgik.mapkit.annotations.toCommon
import ru.sulgik.mapkit.annotations.toNative
import kotlin.time.Instant
import com.yandex.mapkit.directions.driving.DrivingOptions as NativeDrivingOptions

public fun DrivingOptions.toNative(): NativeDrivingOptions {
    return NativeDrivingOptions(
        initialAzimuth,
        routesCount,
        departureTime?.toEpochMilliseconds(),
        annotationLanguage?.toNative(),
        avoidanceFlags?.toNative(),
    )
}

public fun NativeDrivingOptions.toCommon(): DrivingOptions {
    return DrivingOptions(
        initialAzimuth = initialAzimuth,
        routesCount = routesCount,
        departureTime = departureTime?.let { Instant.fromEpochMilliseconds(it) },
        annotationLanguage = annotationLanguage?.toCommon(),
        avoidanceFlags = avoidanceFlags?.toCommon(),
    )
}
