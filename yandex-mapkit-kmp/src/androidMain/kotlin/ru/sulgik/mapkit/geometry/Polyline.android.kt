package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Polyline as NativePolyline

actual class Polyline(private val nativePolyline: NativePolyline) {

    fun toNative(): NativePolyline {
        return nativePolyline
    }

    actual constructor(points: List<Point>) : this(NativePolyline(points.map { it.toNative() }))

    actual val points: List<Point> by lazy {
        nativePolyline.points.map { it.toCommon() }
    }

}

fun NativePolyline.toCommon(): Polyline {
    return Polyline(this)
}