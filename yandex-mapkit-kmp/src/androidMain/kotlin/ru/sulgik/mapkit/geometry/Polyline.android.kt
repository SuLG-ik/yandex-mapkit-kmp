package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Polyline as NativePolyline

public actual class Polyline internal constructor(private val nativePolyline: NativePolyline) {

    public fun toNative(): NativePolyline {
        return nativePolyline
    }

    override fun toString(): String {
        return "Polyline(points=${points.pointsListToString()})"
    }

    public actual constructor(points: List<Point>) : this(NativePolyline(points.map { it.toNative() }))

    public actual val points: List<Point> by lazy {
        nativePolyline.points.map { it.toCommon() }
    }

}

public fun NativePolyline.toCommon(): Polyline {
    return Polyline(this)
}