package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKLinearRing as NativeLinearRing
import YandexMapKit.YMKPolygon as NativePolygon

public actual class Polygon internal constructor(private val nativePolygon: NativePolygon) {

    public fun toNative(): NativePolygon {
        return nativePolygon
    }

    override fun toString(): String {
        return "Polygon(outerRing=$outerRing, innerRing=${innerRing.linearRingsListToString()})"
    }

    public actual constructor(
        outerRing: LinearRing,
        innerRing: List<LinearRing>,
    ) : this(
        NativePolygon.polygonWithOuterRing(
            outerRing = outerRing.toNative(),
            innerRings = innerRing.map { it.toNative() },
        )
    )

    public actual val outerRing: LinearRing by lazy { nativePolygon.outerRing.toCommon() }

    @Suppress("UNCHECKED_CAST")
    public actual val innerRing: List<LinearRing> by lazy { (nativePolygon.innerRings as List<NativeLinearRing>).map { it.toCommon() } }

}

public fun NativePolygon.toCommon(): Polygon {
    return Polygon(this)
}