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
}
