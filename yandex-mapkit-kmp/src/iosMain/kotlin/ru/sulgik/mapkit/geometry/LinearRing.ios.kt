package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPoint
import YandexMapKit.YMKLinearRing as NativeLinearRing

actual class LinearRing(private val nativeLinearRing: NativeLinearRing) {

    fun toNative(): NativeLinearRing {
        return nativeLinearRing
    }

    actual constructor(points: List<Point>) : this(
        NativeLinearRing.linearRingWithPoints(points.map(Point::toNative))
    )

    @Suppress("UNCHECKED_CAST")
    actual val points: List<Point> by lazy {
        (nativeLinearRing.points as List<YMKPoint>).map(YMKPoint::toCommon)
    }


}

fun NativeLinearRing.toCommon(): LinearRing {
    return LinearRing(this)
}