package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPoint
import YandexMapKit.YMKLinearRing as NativeLinearRing

public actual class LinearRing internal constructor(private val nativeLinearRing: NativeLinearRing) {

    public fun toNative(): NativeLinearRing {
        return nativeLinearRing
    }

    public actual constructor(points: List<Point>) : this(
        NativeLinearRing.linearRingWithPoints(points.map(Point::toNative))
    )

    @Suppress("UNCHECKED_CAST")
    public actual val points: List<Point> by lazy {
        (nativeLinearRing.points as List<YMKPoint>).map(YMKPoint::toCommon)
    }


}

public fun NativeLinearRing.toCommon(): LinearRing {
    return LinearRing(this)
}