package ru.sulgik.mapkit

import android.graphics.PointF as NativePointF

public fun PointF.toNative(): NativePointF {
    return NativePointF(x, y)
}

public fun NativePointF.toCommon(): PointF {
    return PointF(x, y)
}