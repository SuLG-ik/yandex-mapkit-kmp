package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.layers.LayerLoadedListener as NativeLayerLoadedListener

/**
 * Notifies when a layer has rendered everything that is visible.
 */
public actual abstract class LayerLoadedListener actual constructor() : NativeConvertible<NativeLayerLoadedListener> {

    private val nativeListener = NativeLayerLoadedListener { onLayerLoaded() }

    override fun toNative(): NativeLayerLoadedListener {
        return nativeListener
    }

    /**
     * Called after the layer has finished loading all visible tiles. This will only be called once.
     * You must set another listener if you want to be notified again.
     */
    public actual abstract fun onLayerLoaded()
}
