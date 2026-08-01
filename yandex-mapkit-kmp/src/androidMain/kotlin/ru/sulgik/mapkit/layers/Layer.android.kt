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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Layer) return false
        if (this::class != other::class) return false
        return nativeLayer == other.nativeLayer
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeLayer.hashCode()
    }
}

public fun NativeLayer.toCommon(): Layer {
    return Layer(this)
}
