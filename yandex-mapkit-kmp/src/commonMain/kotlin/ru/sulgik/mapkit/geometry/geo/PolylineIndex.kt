package ru.sulgik.mapkit.geometry.geo

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.PolylinePosition

/**
 * A spatial index over a polyline.
 */
public expect class PolylineIndex {

    /**
     * Finds closest polyline position. Returns `null` if there is no position that satisfies the
     * condition `distance(point, position) < maxLocationBias`.
     */
    public fun closestPolylinePosition(
        point: Point,
        priority: Priority,
        maxLocationBias: Double,
    ): PolylinePosition?

    /**
     * Finds the closest polyline position between the two positions. Returns `null` if there is no
     * position that satisfies the condition `distance(point, position) < maxLocationBias`.
     */
    public fun closestPolylinePosition(
        point: Point,
        positionFrom: PolylinePosition,
        positionTo: PolylinePosition,
        maxLocationBias: Double,
    ): PolylinePosition?

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
