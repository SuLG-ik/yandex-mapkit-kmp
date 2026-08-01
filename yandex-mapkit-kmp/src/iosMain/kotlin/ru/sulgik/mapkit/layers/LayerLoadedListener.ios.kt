package ru.sulgik.mapkit.layers

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKLayerLoadedListenerProtocol as NativeLayerLoadedListener

/**
 * Notifies when a layer has rendered everything that is visible.
 */
public actual abstract class LayerLoadedListener actual constructor() : NativeConvertible<NativeLayerLoadedListener> {

    private val nativeListener = object : NativeLayerLoadedListener, NSObject() {
        override fun onLayerLoaded() {
            this@LayerLoadedListener.onLayerLoaded()
        }
    }

    override fun toNative(): NativeLayerLoadedListener {
        return nativeListener
    }

    /**
     * Called after the layer has finished loading all visible tiles. This will only be called once.
     * You must set another listener if you want to be notified again.
     */
    public actual abstract fun onLayerLoaded()
}
