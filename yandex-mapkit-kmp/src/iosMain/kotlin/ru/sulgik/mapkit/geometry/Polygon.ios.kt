package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKLinearRing as NativeLinearRing
import YandexMapKit.YMKPolygon as NativePolygon

actual class Polygon(private val nativePolygon: NativePolygon) {

    fun toNative(): NativePolygon {
        return nativePolygon
    }

    actual constructor(
        outerRing: LinearRing,
        innerRing: List<LinearRing>,
    ) : this(
        NativePolygon.polygonWithOuterRing(
            outerRing = outerRing.toNative(),
            innerRings = innerRing.map { it.toNative() },
        )
    )

    actual val outerRing: LinearRing by lazy { nativePolygon.outerRing.toCommon() }

    @Suppress("UNCHECKED_CAST")
    actual val innerRing: List<LinearRing> by lazy { (nativePolygon.innerRings as List<NativeLinearRing>).map { it.toCommon() } }

}

fun NativePolygon.toCommon(): Polygon {
    return Polygon(this)
}