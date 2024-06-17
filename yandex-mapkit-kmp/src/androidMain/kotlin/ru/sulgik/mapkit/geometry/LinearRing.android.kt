package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.LinearRing as NativeLinearRing

actual class LinearRing(private val nativeLinearRing: NativeLinearRing) {

    fun toNative(): NativeLinearRing {
        return nativeLinearRing
    }

    actual constructor(points: List<Point>) : this(NativeLinearRing(points.map { it.toNative() }))

    actual val points: List<Point> by lazy { nativeLinearRing.points.map { it.toCommon() } }

}

fun NativeLinearRing.toCommon(): LinearRing {
    return LinearRing(this)
}