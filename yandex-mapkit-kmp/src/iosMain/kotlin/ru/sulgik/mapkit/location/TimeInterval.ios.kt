package ru.sulgik.mapkit.location

import kotlin.time.Duration.Companion.seconds
import YandexMapKit.YMKTimeInterval as NativeTimeInterval

public fun TimeInterval.toNative(): NativeTimeInterval {
    return NativeTimeInterval.timeIntervalWithFrom(
        from = from.inWholeMilliseconds / 1000.0,
        to = to.inWholeMilliseconds / 1000.0,
    )
}

public fun NativeTimeInterval.toCommon(): TimeInterval {
    return TimeInterval(from = from.seconds, to = to.seconds)
}
