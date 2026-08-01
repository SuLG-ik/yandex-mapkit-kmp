package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPolygon
import YandexMapKit.YMKMultiPolygon as NativeMultiPolygon

public actual class MultiPolygon internal constructor(private val nativeMultiPolygon: NativeMultiPolygon) {

    public fun toNative(): NativeMultiPolygon {
        return nativeMultiPolygon
    }

    override fun toString(): String {
        return "MultiPolygon(polygons=${polygons.polygonsListToString()})"
    }

    public actual constructor(polygons: List<Polygon>) : this(
        NativeMultiPolygon.multiPolygonWithPolygons(polygons.map(Polygon::toNative)),
    )

    public actual val polygons: List<Polygon> by lazy {
        @Suppress("UNCHECKED_CAST")
        (nativeMultiPolygon.polygons as List<YMKPolygon>).map(YMKPolygon::toCommon)
    }

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
