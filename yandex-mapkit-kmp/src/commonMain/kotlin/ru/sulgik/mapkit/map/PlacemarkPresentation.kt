package ru.sulgik.mapkit.map

/**
 * A general interface for placemark presentation objects.
 */
public expect open class PlacemarkPresentation {

    /**
     * Removes the presentation.
     */
    public fun remove()

    /**
     * Tells if this **PlacemarkPresentation** is valid or not.
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
