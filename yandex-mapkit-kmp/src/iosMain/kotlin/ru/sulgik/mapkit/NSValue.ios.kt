package ru.sulgik.mapkit

import kotlinx.cinterop.useContents
import platform.Foundation.NSValue
import platform.UIKit.CGPointValue

internal fun NSValue.toPointF(): PointF {
    return CGPointValue.useContents { toCommon() }
}