package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.PolylinePosition as NativePolylinePosition

public fun PolylinePosition.toNative(): NativePolylinePosition {
    return NativePolylinePosition(segmentIndex, segmentPosition)
}

public fun NativePolylinePosition.toCommon(): PolylinePosition {
    return PolylinePosition(segmentIndex, segmentPosition)
}