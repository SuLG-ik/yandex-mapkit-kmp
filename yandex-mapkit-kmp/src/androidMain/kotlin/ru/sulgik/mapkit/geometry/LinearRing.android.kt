package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.LinearRing as NativeLinearRing

public actual class LinearRing internal constructor(private val nativeLinearRing: NativeLinearRing) {

    public fun toNative(): NativeLinearRing {
        return nativeLinearRing
    }

    override fun toString(): String {
        return "LinearRing(points=${points.pointsListToString()})"
    }

    public actual constructor(points: List<Point>) : this(NativeLinearRing(points.map { it.toNative() }))

    public actual val points: List<Point> by lazy { nativeLinearRing.points.map { it.toCommon() } }

}

public fun NativeLinearRing.toCommon(): LinearRing {
    return LinearRing(this)
}