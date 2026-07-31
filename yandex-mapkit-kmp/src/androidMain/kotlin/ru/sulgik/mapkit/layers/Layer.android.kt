package ru.sulgik.mapkit.layers

import com.yandex.mapkit.layers.Layer as NativeLayer

/**
 * A custom layer added to the map.
 */
public actual class Layer internal constructor(private val nativeLayer: NativeLayer) {

    public fun toNative(): NativeLayer {
        return nativeLayer
    }

    /**
     * Removes the layer from the map.
     */
    public actual fun remove() {
        nativeLayer.remove()
    }

    public actual fun dataSourceLayer(): DataSourceLayer {
        return nativeLayer.dataSourceLayer().toCommon()
    }

    /**
     * Tells if this **Layer** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeLayer.isValid
}

public fun NativeLayer.toCommon(): Layer {
    return Layer(this)
}
