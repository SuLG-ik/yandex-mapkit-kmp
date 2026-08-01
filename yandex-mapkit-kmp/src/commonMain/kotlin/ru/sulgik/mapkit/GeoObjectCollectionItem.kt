package ru.sulgik.mapkit

/**
 * An entry of a [GeoObjectCollection]: either a [GeoObject] or a nested collection.
 */
public expect class GeoObjectCollectionItem {

    public val obj: GeoObject?

    public val collection: GeoObjectCollection?

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
