package ru.sulgik.mapkit.layers

public expect open class ObjectEvent {

    /**
     * Tells if this **ObjectEvent** is valid or not.
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
