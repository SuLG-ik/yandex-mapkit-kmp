package ru.sulgik.mapkit

import kotlinx.cinterop.CValue
import platform.CoreGraphics.CGPoint
import platform.CoreGraphics.CGPointMake

public fun PointF.toNative(): CValue<CGPoint> {
    return CGPointMake(x.toDouble(), y.toDouble())
}

public fun CGPoint.toCommon(): PointF {
    return PointF(x.toFloat(), y.toFloat())
}