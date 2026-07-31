package ru.sulgik.mapkit

import com.yandex.mapkit.Time as NativeTime

public fun Time.toNative(): NativeTime {
    return NativeTime(value, tzOffset, text)
}

public fun NativeTime.toCommon(): Time {
    return Time(value = value, tzOffset = tzOffset, text = text)
}
