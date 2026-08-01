package ru.sulgik.mapkit.geometry

public expect class LinearRing {

    public constructor(points: List<Point>)

    public val points: List<Point>

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}

internal fun List<LinearRing>.linearRingsListToString(): String {
    return "[${joinToString(", ")}]"
}
