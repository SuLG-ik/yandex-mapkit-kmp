package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPoint as NativePoint
import YandexMapKit.YMKPolyline as NativePolyline

public actual class Polyline internal constructor(private val nativePolyline: NativePolyline) {

    public fun toNative(): NativePolyline {
        return nativePolyline
    }

    override fun toString(): String {
        return "Polyline(points=${points.pointsListToString()})"
    }

    public actual constructor(points: List<Point>) : this(
        NativePolyline.polylineWithPoints(points.map(Point::toNative))
    )

    public actual val points: List<Point>
        @Suppress("UNCHECKED_CAST")
        get() = (nativePolyline.points as List<NativePoint>).map { it.toCommon() }

}

public fun NativePolyline.toCommon(): Polyline {
    return Polyline(this)
}