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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Projection) return false
        if (this::class != other::class) return false
        return nativeProjection == other.nativeProjection
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeProjection.hashCode()
    }
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
