package ru.sulgik.mapkit.ui

import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKOverlay as NativeOverlay

/**
 * A raster image drawn on top of the map, in screen coordinates.
 */
public actual class Overlay internal constructor(private val nativeOverlay: NativeOverlay) {

    public fun toNative(): NativeOverlay {
        return nativeOverlay
    }

    /**
     * Sets image as content of overlay, resets view.
     */
    public actual fun setImage(image: ImageProvider, rect: ScreenRect) {
        nativeOverlay.setImageWithImage(image.toNative(), rect.toNative())
    }

    /**
     * Removes the overlay from the map.
     */
    public actual fun remove() {
        nativeOverlay.remove()
    }

    /**
     * Tells if this **Overlay** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeOverlay.isValid()
}

public fun NativeOverlay.toCommon(): Overlay {
    return Overlay(this)
}
