package ru.sulgik.mapkit.map

/**
 * Provides an interface to set icon and its style for a placemark.
 */
public expect class Icon : PlacemarkPresentation {

    /**
     * The style properties (scale, zIndex, etc.) of the icon placemark.
     */
    public var style: IconStyle

    /**
     * Sets the image for the icon.
     *
     * @param onFinished Called when the image is applied.
     */
    public fun setImage(
        image: ImageProvider,
        style: IconStyle? = null,
        onFinished: Callback? = null,
    )
}
