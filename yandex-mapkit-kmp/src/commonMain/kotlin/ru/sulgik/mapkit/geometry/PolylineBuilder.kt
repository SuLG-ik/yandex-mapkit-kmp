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
 * Creates an empty [PolylineBuilder].
 */
public expect fun PolylineBuilder(): PolylineBuilder
