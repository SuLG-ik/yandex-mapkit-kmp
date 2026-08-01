package ru.sulgik.mapkit.geometry

public expect class Polygon {

    public constructor(outerRing: LinearRing, innerRings: List<LinearRing>)

    public val outerRing: LinearRing

    public val innerRings: List<LinearRing>

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
