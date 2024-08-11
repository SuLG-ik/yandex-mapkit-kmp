package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.MultiPolygon as NativeMultiPolygon

public actual class MultiPolygon internal constructor(private val nativeMultiPolygon: NativeMultiPolygon) {

    public fun toNative(): NativeMultiPolygon {
        return nativeMultiPolygon
    }

    public actual constructor(polygons: List<Polygon>) : this(NativeMultiPolygon(polygons.map { it.toNative() }))

    public actual val polygons: List<Polygon> by lazy { nativeMultiPolygon.polygons.map { it.toCommon() } }

}

public fun NativeMultiPolygon.toCommon(): MultiPolygon {
    return MultiPolygon(this)
}