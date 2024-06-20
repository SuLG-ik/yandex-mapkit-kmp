package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPolygon
import YandexMapKit.YMKMultiPolygon as NativeMultiPolygon

actual class MultiPolygon(private val nativeMultiPolygon: NativeMultiPolygon) {

    fun toNative(): NativeMultiPolygon {
        return nativeMultiPolygon
    }

    actual constructor(polygons: List<Polygon>) : this(
        NativeMultiPolygon.multiPolygonWithPolygons(polygons.map(Polygon::toNative))
    )

    actual val polygons: List<Polygon> by lazy {
        @Suppress("UNCHECKED_CAST")
        (nativeMultiPolygon.polygons as List<YMKPolygon>).map(YMKPolygon::toCommon)
    }

}

fun NativeMultiPolygon.toCommon(): MultiPolygon {
    return MultiPolygon(this)
}