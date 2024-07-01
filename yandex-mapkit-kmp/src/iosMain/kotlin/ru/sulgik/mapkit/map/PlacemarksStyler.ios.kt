package ru.sulgik.mapkit.map

import platform.Foundation.NSValue
import platform.UIKit.valueWithCGPoint
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKPlacemarksStyler as NativePlacemarksStyler

actual class PlacemarksStyler(private val nativePlacemarkStyle: NativePlacemarksStyler) {

    fun toNative(): NativePlacemarksStyler {
        return nativePlacemarkStyle
    }

    actual fun setScaleFunction(points: List<PointF>) {
        nativePlacemarkStyle.setScaleFunctionWithPoints(points.map { NSValue.valueWithCGPoint(it.toNative()) })
    }

}

fun NativePlacemarksStyler.toCommon(): PlacemarksStyler {
    return PlacemarksStyler(this)
}