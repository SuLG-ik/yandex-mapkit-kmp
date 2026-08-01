package ru.sulgik.mapkit.geometry.geo

/**
 * How [PolylineIndex] picks the closest polyline position.
 */
public enum class Priority {

    /**
     * Find the closest polyline position to a raw point.
     */
    CLOSEST_TO_RAW_POINT,

    /**
     * Find the closest polyline position to the polyline start.
     */
    CLOSEST_TO_START,
}
