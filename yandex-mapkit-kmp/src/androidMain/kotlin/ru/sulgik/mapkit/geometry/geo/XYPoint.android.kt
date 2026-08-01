package ru.sulgik.mapkit.geometry.geo

import com.yandex.mapkit.geometry.geo.XYPoint as NativeXYPoint

public fun XYPoint.toNative(): NativeXYPoint {
    return NativeXYPoint(x, y)
}

public fun NativeXYPoint.toCommon(): XYPoint {
    return XYPoint(x = x, y = y)
}
