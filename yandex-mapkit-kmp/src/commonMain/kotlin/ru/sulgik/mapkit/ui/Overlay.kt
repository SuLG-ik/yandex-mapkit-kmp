package ru.sulgik.mapkit.ui

import ru.sulgik.mapkit.ScreenRect
import ru.sulgik.mapkit.map.ImageProvider

/**
 * A raster image drawn on top of the map, in screen coordinates.
 */
public expect class Overlay {

    /**
     * Sets image as content of overlay, resets view.
     */
    public fun setImage(image: ImageProvider, rect: ScreenRect)

    /**
     * Removes the overlay from the map.
     */
    public fun remove()

    /**
     * Tells if this **Overlay** is valid or not.
     */
    public val isValid: Boolean
}
