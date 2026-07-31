package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.WeakRef

/**
 * The data source part of a layer.
 */
public expect class DataSourceLayer {

    /**
     * Manages visibility of the layer.
     */
    public var isActive: Boolean

    /**
     * Clears all cached tiles and starts new requests for tiles that are displayed.
     */
    public fun clear()

    /**
     * Applies JSON style transformation to the layer.
     */
    public fun setStyle(id: Int, style: String): Boolean

    /**
     * Resets all JSON style transformations applied to the layer.
     */
    public fun resetStyles()

    /**
     * Sets layer loaded listener.
     */
    public fun setLayerLoadedListener(layerLoadedListener: WeakRef<LayerLoadedListener>?)

    /**
     * Sets data source listener.
     */
    public fun setDataSourceListener(dataSourceListener: WeakRef<DataSourceListener>?)

    /**
     * Removes the data source layer from the parent layer.
     */
    public fun remove()

    /**
     * Tells if this **DataSourceLayer** is valid or not.
     */
    public val isValid: Boolean
}
