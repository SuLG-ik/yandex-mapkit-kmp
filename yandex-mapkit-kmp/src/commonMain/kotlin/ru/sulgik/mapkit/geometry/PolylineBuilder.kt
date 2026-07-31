package ru.sulgik.mapkit.geometry

/**
 * Assembles a polyline point by point.
 */
public expect class PolylineBuilder {

    /**
     * Appends a polyline.
     */
    public fun append(polyline: Polyline)

    /**
     * Appends a point.
     */
    public fun append(point: Point)

    /**
     * Builds a polyline.
     */
    public fun build(): Polyline
}

/**
 * Creates an empty [PolylineBuilder].
 */
public expect fun PolylineBuilder(): PolylineBuilder
