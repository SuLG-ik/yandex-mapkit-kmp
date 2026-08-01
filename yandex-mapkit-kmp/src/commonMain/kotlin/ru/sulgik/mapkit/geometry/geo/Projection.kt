package ru.sulgik.mapkit.geometry.geo

import ru.sulgik.mapkit.geometry.Point

/**
 * Maps world coordinates onto the flat world and back.
 */
public expect class Projection {

    /**
     * Converts the world coordinates to a flat world position.
     */
    public fun worldToXY(geoPoint: Point, zoom: Int): XYPoint

    /**
     * Converts the flat world position to world coordinates.
     */
    public fun xyToWorld(xyPoint: XYPoint, zoom: Int): Point

    /**
     * Tells if this **Projection** is valid or not.
     */
    public val isValid: Boolean

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}

/**
 * The projections MapKit ships with.
 */
public expect object Projections {

    public val wgs84Mercator: Projection

    public val sphericalMercator: Projection
}
