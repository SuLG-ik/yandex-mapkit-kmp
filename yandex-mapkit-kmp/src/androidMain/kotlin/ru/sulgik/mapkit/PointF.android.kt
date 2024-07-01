package ru.sulgik.mapkit

import android.graphics.PointF as NativePointF

fun PointF.toNative(): NativePointF {
    return NativePointF(x, y)
}

fun NativePointF.toCommon(): PointF {
    return PointF(x, y)
}