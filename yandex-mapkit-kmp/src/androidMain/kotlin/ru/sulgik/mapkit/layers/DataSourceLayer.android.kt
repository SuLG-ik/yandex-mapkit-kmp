package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.layers.DataSourceLayer as NativeDataSourceLayer

/**
 * The data source part of a layer.
 */
public actual class DataSourceLayer internal constructor(
    private val nativeDataSourceLayer: NativeDataSourceLayer,
) {

    public fun toNative(): NativeDataSourceLayer {
        return nativeDataSourceLayer
    }

    /**
     * Manages visibility of the layer.
     */
    public actual var isActive: Boolean
        get() = nativeDataSourceLayer.isActive
        set(value) {
            nativeDataSourceLayer.setActive(value)
        }

    /**
     * Clears all cached tiles and starts new requests for tiles that are displayed.
     */
    public actual fun clear() {
        nativeDataSourceLayer.clear()
    }

    /**
     * Applies JSON style transformation to the layer.
     */
    public actual fun setStyle(id: Int, style: String): Boolean {
        return nativeDataSourceLayer.setStyle(id, style)
    }

    /**
     * Resets all JSON style transformations applied to the layer.
     */
    public actual fun resetStyles() {
        nativeDataSourceLayer.resetStyles()
    }

    /**
     * Sets layer loaded listener.
     */
    public actual fun setLayerLoadedListener(layerLoadedListener: WeakRef<LayerLoadedListener>?) {
        nativeDataSourceLayer.setLayerLoadedListener(layerLoadedListener?.toNative())
    }

    /**
     * Sets data source listener.
     */
    public actual fun setDataSourceListener(dataSourceListener: WeakRef<DataSourceListener>?) {
        nativeDataSourceLayer.setDataSourceListener(dataSourceListener?.toNative())
    }

    /**
     * Removes the data source layer from the parent layer.
     */
    public actual fun remove() {
        nativeDataSourceLayer.remove()
    }

    /**
     * Tells if this **DataSourceLayer** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeDataSourceLayer.isValid
}

public fun NativeDataSourceLayer.toCommon(): DataSourceLayer {
    return DataSourceLayer(this)
}
