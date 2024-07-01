package ru.sulgik.mapkit

import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import platform.CoreGraphics.CGPointMake
import platform.Foundation.NSValue
import platform.Foundation.getValue

fun NSValue.toPointF(): PointF {
    return memScoped {
        val pointer = CGPointMake(0.0, 0.0).getPointer(this)
        getValue(pointer)
        pointer.pointed.toCommon()
    }
}