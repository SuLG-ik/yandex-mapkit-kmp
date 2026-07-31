package ru.sulgik.mapkit.geometry.geo

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.geometry.geo.Projection as NativeProjection
import com.yandex.mapkit.geometry.geo.Projections as NativeProjections

/**
 * Maps world coordinates onto the flat world and back.
 */
public actual class Projection internal constructor(private val nativeProjection: NativeProjection) {

    public fun toNative(): NativeProjection {
        return nativeProjection
    }

    /**
     * Converts the world coordinates to a flat world position.
     */
    public actual fun worldToXY(geoPoint: Point, zoom: Int): XYPoint {
        return nativeProjection.worldToXY(geoPoint.toNative(), zoom).toCommon()
    }

    /**
     * Converts the flat world position to world coordinates.
     */
    public actual fun xyToWorld(xyPoint: XYPoint, zoom: Int): Point {
        return nativeProjection.xyToWorld(xyPoint.toNative(), zoom).toCommon()
    }

    /**
     * Tells if this **Projection** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeProjection.isValid
}

public fun NativeProjection.toCommon(): Projection {
    return Projection(this)
}

/**
 * The projections MapKit ships with.
 */
public actual object Projections {

    public actual val wgs84Mercator: Projection
        get() = NativeProjections.getWgs84Mercator().toCommon()

    public actual val sphericalMercator: Projection
        get() = NativeProjections.getSphericalMercator().toCommon()
}
