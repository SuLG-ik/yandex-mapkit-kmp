package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Polygon as NativePolygon

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
    ) : this(NativePolygon(outerRing.toNative(), innerRing.map { it.toNative() }))

    public actual val outerRing: LinearRing by lazy { nativePolygon.outerRing.toCommon() }
    public actual val innerRing: List<LinearRing> by lazy { nativePolygon.innerRings.map { it.toCommon() } }

}

public fun NativePolygon.toCommon(): Polygon {
    return Polygon(this)
}