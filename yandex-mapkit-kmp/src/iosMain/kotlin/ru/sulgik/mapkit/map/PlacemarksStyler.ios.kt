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

}

public fun NativePlacemarksStyler.toCommon(): PlacemarksStyler {
    return PlacemarksStyler(this)
}