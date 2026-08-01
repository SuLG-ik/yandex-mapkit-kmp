package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.GeoObject

/**
 * A tap on an object of the base map.
 */
public expect class GeoObjectTapEvent {

    /**
     * The object that was tapped.
     */
    public val geoObject: GeoObject

    /**
     * Tells if this **GeoObjectTapEvent** is valid or not.
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
