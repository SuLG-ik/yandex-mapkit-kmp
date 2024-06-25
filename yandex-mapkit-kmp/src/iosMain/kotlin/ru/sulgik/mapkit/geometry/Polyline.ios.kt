package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPoint as NativePoint
import YandexMapKit.YMKPolyline as NativePolyline

actual class Polyline internal constructor(private val nativePolyline: NativePolyline) {

    fun toNative(): NativePolyline {
        return nativePolyline
    }

    actual constructor(points: List<Point>) : this(
        NativePolyline.polylineWithPoints(points.map(Point::toNative))
    )

    actual val points: List<Point>
        @Suppress("UNCHECKED_CAST")
        get() = (nativePolyline.points as List<NativePoint>).map { it.toCommon() }

}

fun NativePolyline.toCommon(): Polyline {
    return Polyline(this)
}