package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.Range as NativeRange

public fun Range.toNative(): NativeRange {
    return NativeRange(from, to)
}

public fun NativeRange.toCommon(): Range {
    return Range(from = from, to = to)
}
