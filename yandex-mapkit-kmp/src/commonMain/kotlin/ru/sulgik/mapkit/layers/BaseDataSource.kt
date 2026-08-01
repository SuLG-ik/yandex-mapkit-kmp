package ru.sulgik.mapkit.layers

/**
 * The data behind a layer.
 */
public expect open class BaseDataSource {

    /**
     * Stores id of data source.
     */
    public val id: String

    /**
     * Tells if this **BaseDataSource** is valid or not.
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
