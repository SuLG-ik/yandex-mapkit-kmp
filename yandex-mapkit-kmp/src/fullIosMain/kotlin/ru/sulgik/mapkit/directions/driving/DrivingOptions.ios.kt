package ru.sulgik.mapkit.directions.driving

import platform.Foundation.NSDate
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import ru.sulgik.mapkit.annotations.toCommon
import ru.sulgik.mapkit.annotations.toNative
import ru.sulgik.mapkit.toNSNumber
import kotlin.math.roundToLong
import kotlin.time.Instant
import YandexMapKit.YMKAnnotationLanguage as NativeAnnotationLanguage
import YandexMapKit.YMKDrivingOptions as NativeDrivingOptions

public fun DrivingOptions.toNative(): NativeDrivingOptions {
    return NativeDrivingOptions.drivingOptionsWithInitialAzimuth(
        initialAzimuth = initialAzimuth?.toNSNumber(),
        routesCount = routesCount?.toNSNumber(),
        departureTime = departureTime?.let { NSDate.dateWithTimeIntervalSince1970(it.toEpochMilliseconds() / 1000.0) },
        annotationLanguage = annotationLanguage?.toNative()?.value?.toLong()?.toNSNumber(),
        avoidanceFlags = avoidanceFlags?.toNative(),
    )
}

public fun NativeDrivingOptions.toCommon(): DrivingOptions {
    return DrivingOptions(
        initialAzimuth = initialAzimuth?.doubleValue,
        routesCount = routesCount?.intValue,
        departureTime = departureTime?.let { Instant.fromEpochMilliseconds((it.timeIntervalSince1970 * 1000.0).roundToLong()) },
        annotationLanguage = annotationLanguage?.let { NativeAnnotationLanguage.byValue(it.unsignedLongValue).toCommon() },
        avoidanceFlags = avoidanceFlags?.toCommon(),
    )
}
