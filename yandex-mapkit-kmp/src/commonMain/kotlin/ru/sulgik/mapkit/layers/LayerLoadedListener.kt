package ru.sulgik.mapkit.layers

/**
 * Notifies when a layer has rendered everything that is visible.
 */
public expect abstract class LayerLoadedListener() {

    /**
     * Called after the layer has finished loading all visible tiles. This will only be called once.
     * You must set another listener if you want to be notified again.
     */
    public abstract fun onLayerLoaded()
}

public inline fun LayerLoadedListener(
    crossinline onLayerLoaded: () -> Unit,
): LayerLoadedListener {
    return object : LayerLoadedListener() {
        override fun onLayerLoaded() {
            onLayerLoaded.invoke()
        }
    }
}
