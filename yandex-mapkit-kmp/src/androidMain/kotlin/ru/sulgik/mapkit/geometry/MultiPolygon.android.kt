package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.MultiPolygon as NativeMultiPolygon

public actual class MultiPolygon internal constructor(private val nativeMultiPolygon: NativeMultiPolygon) {

    public fun toNative(): NativeMultiPolygon {
        return nativeMultiPolygon
    }

    override fun toString(): String {
        return "MultiPolygon(polygons=${polygons.polygonsListToString()})"
    }

    public actual constructor(polygons: List<Polygon>) : this(NativeMultiPolygon(polygons.map { it.toNative() }))

    public actual val polygons: List<Polygon> by lazy { nativeMultiPolygon.polygons.map { it.toCommon() } }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MultiPolygon) return false
        if (this::class != other::class) return false
        return nativeMultiPolygon == other.nativeMultiPolygon
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeMultiPolygon.hashCode()
    }
}

public fun NativeMultiPolygon.toCommon(): MultiPolygon {
    return MultiPolygon(this)
}
