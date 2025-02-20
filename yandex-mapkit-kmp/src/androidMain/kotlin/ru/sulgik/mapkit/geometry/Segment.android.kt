package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Segment as NativeSegment

public fun Segment.toNative(): NativeSegment {
    return NativeSegment(startPoint.toNative(), endPoint.toNative())
}

public fun NativeSegment.toCommon(): Segment {
    return Segment(startPoint.toCommon(), endPoint.toCommon())
}