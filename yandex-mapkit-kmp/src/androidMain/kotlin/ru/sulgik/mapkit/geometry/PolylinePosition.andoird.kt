package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.PolylinePosition as NativePolylinePosition

fun PolylinePosition.toNative(): NativePolylinePosition {
    return NativePolylinePosition(segmentIndex, segmentPosition)
}

fun NativePolylinePosition.toCommon(): PolylinePosition {
    return PolylinePosition(segmentIndex, segmentPosition)
}