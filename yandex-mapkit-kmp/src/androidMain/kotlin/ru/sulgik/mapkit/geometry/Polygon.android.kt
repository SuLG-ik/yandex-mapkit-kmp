package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Polygon as NativePolygon

actual class Polygon internal constructor(private val nativePolygon: NativePolygon) {

    fun toNative(): NativePolygon {
        return nativePolygon
    }

    actual constructor(
        outerRing: LinearRing,
        innerRing: List<LinearRing>,
    ) : this(NativePolygon(outerRing.toNative(), innerRing.map { it.toNative() }))

    actual val outerRing: LinearRing by lazy { nativePolygon.outerRing.toCommon() }
    actual val innerRing: List<LinearRing> by lazy { nativePolygon.innerRings.map { it.toCommon() } }

}

fun NativePolygon.toCommon(): Polygon {
    return Polygon(this)
}