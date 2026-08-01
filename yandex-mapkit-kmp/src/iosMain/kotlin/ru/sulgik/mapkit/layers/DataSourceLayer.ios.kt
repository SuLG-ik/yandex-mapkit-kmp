package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKDataSourceLayer as NativeDataSourceLayer

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
        get() = nativeDataSourceLayer.isActive()
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
        return nativeDataSourceLayer.setStyleWithId(id.toLong(), style)
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
        nativeDataSourceLayer.setLayerLoadedListenerWithLayerLoadedListener(layerLoadedListener?.toNative())
    }

    /**
     * Sets data source listener.
     */
    public actual fun setDataSourceListener(dataSourceListener: WeakRef<DataSourceListener>?) {
        nativeDataSourceLayer.setDataSourceListenerWithDataSourceListener(dataSourceListener?.toNative())
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
        get() = nativeDataSourceLayer.isValid()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DataSourceLayer) return false
        if (this::class != other::class) return false
        return nativeDataSourceLayer == other.nativeDataSourceLayer
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeDataSourceLayer.hashCode()
    }
}

public fun NativeDataSourceLayer.toCommon(): DataSourceLayer {
    return DataSourceLayer(this)
}
