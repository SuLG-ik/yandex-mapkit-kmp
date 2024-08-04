package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPolygon
import YandexMapKit.YMKMultiPolygon as NativeMultiPolygon

public actual class MultiPolygon internal constructor(private val nativeMultiPolygon: NativeMultiPolygon) {

    public fun toNative(): NativeMultiPolygon {
        return nativeMultiPolygon
    }

    public actual constructor(polygons: List<Polygon>) : this(
        NativeMultiPolygon.multiPolygonWithPolygons(polygons.map(Polygon::toNative))
    )

    public actual val polygons: List<Polygon> by lazy {
        @Suppress("UNCHECKED_CAST")
        (nativeMultiPolygon.polygons as List<YMKPolygon>).map(YMKPolygon::toCommon)
    }

}

public fun NativeMultiPolygon.toCommon(): MultiPolygon {
    return MultiPolygon(this)
}