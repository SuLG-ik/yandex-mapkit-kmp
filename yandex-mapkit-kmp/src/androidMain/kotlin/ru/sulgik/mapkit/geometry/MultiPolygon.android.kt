package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.MultiPolygon as NativeMultiPolygon

actual class MultiPolygon(private val nativeMultiPolygon: NativeMultiPolygon) {

    fun toNative(): NativeMultiPolygon {
        return nativeMultiPolygon
    }

    actual constructor(polygons: List<Polygon>) : this(NativeMultiPolygon(polygons.map { it.toNative() }))

    actual val polygons: List<Polygon> by lazy { nativeMultiPolygon.polygons.map { it.toCommon() } }

}

fun NativeMultiPolygon.toCommon(): MultiPolygon {
    return MultiPolygon(this)
}