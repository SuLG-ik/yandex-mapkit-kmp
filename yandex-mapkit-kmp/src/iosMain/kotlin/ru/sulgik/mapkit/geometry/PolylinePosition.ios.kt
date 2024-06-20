package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPolylinePosition as NativePolylinePosition

fun PolylinePosition.toNative(): NativePolylinePosition {
    return NativePolylinePosition.polylinePositionWithSegmentIndex(
        segmentIndex = segmentIndex.toULong(),
        segmentPosition = segmentPosition,
    )
}

fun NativePolylinePosition.toCommon(): PolylinePosition {
    return PolylinePosition(
        segmentIndex = segmentIndex.toInt(),
        segmentPosition = segmentPosition,
    )
}