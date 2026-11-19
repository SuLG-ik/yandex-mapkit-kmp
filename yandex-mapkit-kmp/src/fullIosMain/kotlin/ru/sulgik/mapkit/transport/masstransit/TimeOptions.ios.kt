package ru.sulgik.mapkit.transport.masstransit

import platform.Foundation.NSDate
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import kotlin.math.roundToLong
import kotlin.time.Instant
import YandexMapKit.YMKTimeOptions as NativeTimeOptions

/** Converts this TimeOptions to the native value. */
public fun TimeOptions.toNative(): NativeTimeOptions =
    NativeTimeOptions.timeOptionsWithDepartureTime(
        departureTime = departureTime.toDate(),
        arrivalTime = arrivalTime.toDate(),
    )

/** Reads this native TimeOptions. */
public fun NativeTimeOptions.toCommon(): TimeOptions =
    TimeOptions(
        departureTime = departureTime.toInstant(),
        arrivalTime = arrivalTime.toInstant(),
    )

private fun Instant?.toDate(): NSDate? = this?.let { NSDate.dateWithTimeIntervalSince1970(it.toEpochMilliseconds() / 1000.0) }

private fun NSDate?.toInstant(): Instant? = this?.let { Instant.fromEpochMilliseconds((it.timeIntervalSince1970 * 1000.0).roundToLong()) }
