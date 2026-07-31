package ru.sulgik.mapkit

import YandexMapKit.YMKZoomRange as NativeZoomRange

public fun ZoomRange.toNative(): NativeZoomRange {
    return NativeZoomRange.zoomRangeWithZMin(zMin = zMin.toULong(), zMax = zMax.toULong())
}

public fun NativeZoomRange.toCommon(): ZoomRange {
    return ZoomRange(zMin = zMin.toInt(), zMax = zMax.toInt())
}
