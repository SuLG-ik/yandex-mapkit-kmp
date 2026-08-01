package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.PointF

public expect class PlacemarksStyler {

    public fun setScaleFunction(points: List<PointF>)
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
