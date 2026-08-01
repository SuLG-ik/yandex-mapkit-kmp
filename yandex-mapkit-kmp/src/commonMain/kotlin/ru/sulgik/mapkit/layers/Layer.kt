package ru.sulgik.mapkit.layers

/**
 * A custom layer added to the map.
 */
public expect class Layer {

    /**
     * Removes the layer from the map.
     */
    public fun remove()

    public fun dataSourceLayer(): DataSourceLayer

    /**
     * Tells if this **Layer** is valid or not.
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
