package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPolylinePosition as NativePolylinePosition

public fun PolylinePosition.toNative(): NativePolylinePosition {
    return NativePolylinePosition.polylinePositionWithSegmentIndex(
        segmentIndex = segmentIndex.toULong(),
        segmentPosition = segmentPosition,
    )
}

public fun NativePolylinePosition.toCommon(): PolylinePosition {
    return PolylinePosition(
        segmentIndex = segmentIndex.toInt(),
        segmentPosition = segmentPosition,
    )
}