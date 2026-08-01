package ru.sulgik.mapkit.location

import YandexMapKit.YMKRange as NativeRange

public fun Range.toNative(): NativeRange {
    return NativeRange.rangeWithFrom(from = from, to = to)
}

public fun NativeRange.toCommon(): Range {
    return Range(from = from, to = to)
}
