package ru.sulgik.mapkit.location

import kotlin.time.Duration.Companion.milliseconds
import com.yandex.mapkit.location.TimeInterval as NativeTimeInterval

public fun TimeInterval.toNative(): NativeTimeInterval {
    return NativeTimeInterval(from.inWholeMilliseconds, to.inWholeMilliseconds)
}

public fun NativeTimeInterval.toCommon(): TimeInterval {
    return TimeInterval(from = from.milliseconds, to = to.milliseconds)
}
