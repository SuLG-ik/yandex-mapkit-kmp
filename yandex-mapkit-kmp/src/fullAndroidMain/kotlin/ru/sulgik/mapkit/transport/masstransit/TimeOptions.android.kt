package ru.sulgik.mapkit.transport.masstransit

import kotlin.time.Instant
import com.yandex.mapkit.transport.masstransit.TimeOptions as NativeTimeOptions

/** Converts this TimeOptions to the native value. */
public fun TimeOptions.toNative(): NativeTimeOptions {
    return NativeTimeOptions(
        departureTime?.toEpochMilliseconds(),
        arrivalTime?.toEpochMilliseconds(),
    )
}

/** Reads this native TimeOptions. */
public fun NativeTimeOptions.toCommon(): TimeOptions {
    return TimeOptions(
        departureTime = departureTime?.let { Instant.fromEpochMilliseconds(it) },
        arrivalTime = arrivalTime?.let { Instant.fromEpochMilliseconds(it) },
    )
}
