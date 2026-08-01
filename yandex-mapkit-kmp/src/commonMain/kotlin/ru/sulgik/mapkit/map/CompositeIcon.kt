package ru.sulgik.mapkit.map

/**
 * Provides an interface to set several icons and their styles for a placemark.
 */
public expect class CompositeIcon : PlacemarkPresentation {

    /**
     * Creates or resets a named layer with an icon and its style.
     *
     * @param onFinished Called when the icon is applied.
     */
    public fun setIcon(
        name: String,
        image: ImageProvider,
        style: IconStyle? = null,
        onFinished: Callback? = null,
    )

    /**
     * Changes the icon style for a specific layer.
     */
    public fun setIconStyle(name: String, style: IconStyle)

    /**
     * Returns named [Icon] object that can be used to set icon and its style.
     */
    public fun icon(name: String): Icon

    /**
     * Removes the named layer.
     */
    public fun removeIcon(name: String)

    /**
     * Removes all layers.
     */
    public fun removeAll()
}
