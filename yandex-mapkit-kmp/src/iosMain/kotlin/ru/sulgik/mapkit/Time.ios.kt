package ru.sulgik.mapkit

import YandexMapKit.YMKTime as NativeTime

public fun Time.toNative(): NativeTime {
    return NativeTime.timeWithValue(value = value, tzOffset = tzOffset.toLong(), text = text)
}

public fun NativeTime.toCommon(): Time {
    return Time(value = value, tzOffset = tzOffset.toInt(), text = text)
}
