package ru.sulgik.mapkit.map

import platform.Foundation.NSValue
import platform.UIKit.valueWithCGPoint
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKPlacemarksStyler as NativePlacemarksStyler

public actual class PlacemarksStyler internal constructor(private val nativePlacemarkStyle: NativePlacemarksStyler) {

    public fun toNative(): NativePlacemarksStyler {
        return nativePlacemarkStyle
    }

    public actual fun setScaleFunction(points: List<PointF>) {
        nativePlacemarkStyle.setScaleFunctionWithPoints(points.map { NSValue.valueWithCGPoint(it.toNative()) })
    }

    public actual val isValid: Boolean
        get() = nativePlacemarkStyle.isValid()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PlacemarksStyler) return false
        if (this::class != other::class) return false
        return nativePlacemarkStyle == other.nativePlacemarkStyle
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativePlacemarkStyle.hashCode()
    }
}

public fun NativePlacemarksStyler.toCommon(): PlacemarksStyler {
    return PlacemarksStyler(this)
}
