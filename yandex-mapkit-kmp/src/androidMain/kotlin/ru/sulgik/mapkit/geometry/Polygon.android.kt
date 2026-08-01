package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Polygon as NativePolygon

public actual class Polygon internal constructor(private val nativePolygon: NativePolygon) {

    public fun toNative(): NativePolygon {
        return nativePolygon
    }

    override fun toString(): String {
        return "Polygon(outerRing=$outerRing, innerRings=${innerRings.linearRingsListToString()})"
    }

    public actual constructor(
        outerRing: LinearRing,
        innerRings: List<LinearRing>,
    ) : this(NativePolygon(outerRing.toNative(), innerRings.map { it.toNative() }))

    public actual val outerRing: LinearRing by lazy { nativePolygon.outerRing.toCommon() }
    public actual val innerRings: List<LinearRing> by lazy { nativePolygon.innerRings.map { it.toCommon() } }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Polygon) return false
        if (this::class != other::class) return false
        return nativePolygon == other.nativePolygon
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativePolygon.hashCode()
    }
}

public fun NativePolygon.toCommon(): Polygon {
    return Polygon(this)
}
