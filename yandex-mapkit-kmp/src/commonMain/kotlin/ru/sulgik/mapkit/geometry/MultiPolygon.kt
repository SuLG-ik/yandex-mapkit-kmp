package ru.sulgik.mapkit.geometry

public expect class MultiPolygon {

    public constructor(polygons: List<Polygon>)

    public val polygons: List<Polygon>

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
