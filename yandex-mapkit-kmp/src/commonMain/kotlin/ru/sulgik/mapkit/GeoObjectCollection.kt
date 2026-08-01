package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.BoundingBox

/**
 * A tree of geo objects.
 */
public expect class GeoObjectCollection {

    /**
     * The bounds around the collection of objects.
     */
    public val boundingBox: BoundingBox?

    /**
     * The objects and the nested collections.
     */
    public val children: List<GeoObjectCollectionItem>

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
