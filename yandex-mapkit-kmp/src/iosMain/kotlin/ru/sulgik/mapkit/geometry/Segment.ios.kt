package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKSegment as NativeSegment

public fun Segment.toNative(): NativeSegment {
    return NativeSegment.segmentWithStartPoint(startPoint.toNative(), endPoint.toNative())
}

public fun NativeSegment.toCommon(): Segment {
    return Segment(startPoint.toCommon(), endPoint.toCommon())
}