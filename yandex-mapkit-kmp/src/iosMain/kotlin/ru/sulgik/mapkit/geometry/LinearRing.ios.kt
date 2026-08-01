package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPoint
import YandexMapKit.YMKLinearRing as NativeLinearRing

public actual class LinearRing internal constructor(private val nativeLinearRing: NativeLinearRing) {

    public fun toNative(): NativeLinearRing {
        return nativeLinearRing
    }

    public actual constructor(points: List<Point>) : this(
        NativeLinearRing.linearRingWithPoints(points.map(Point::toNative)),
    )

    @Suppress("UNCHECKED_CAST")
    public actual val points: List<Point> by lazy {
        (nativeLinearRing.points as List<YMKPoint>).map(YMKPoint::toCommon)
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LinearRing) return false
        if (this::class != other::class) return false
        return nativeLinearRing == other.nativeLinearRing
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeLinearRing.hashCode()
    }
}

public fun NativeLinearRing.toCommon(): LinearRing {
    return LinearRing(this)
}
