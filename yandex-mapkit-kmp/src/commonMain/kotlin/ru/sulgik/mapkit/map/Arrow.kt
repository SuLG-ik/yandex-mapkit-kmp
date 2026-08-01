package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.PolylinePosition

public expect class Arrow {

    public val position: PolylinePosition

    public var fillColor: Color

    public var outlineColor: Color

    public var outlineWidth: Float

    public var length: Float

    public var isVisible: Boolean

    public var triangleHeight: Float

    /**
     * Tells if this **Arrow** is valid or not.
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
