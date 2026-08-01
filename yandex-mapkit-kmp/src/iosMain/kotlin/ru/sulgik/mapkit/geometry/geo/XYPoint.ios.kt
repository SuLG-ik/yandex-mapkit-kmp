package ru.sulgik.mapkit.geometry.geo

import YandexMapKit.YMKXYPoint as NativeXYPoint

public fun XYPoint.toNative(): NativeXYPoint {
    return NativeXYPoint.xYPointWithX(x = x, y = y)
}

public fun NativeXYPoint.toCommon(): XYPoint {
    return XYPoint(x = x, y = y)
}
