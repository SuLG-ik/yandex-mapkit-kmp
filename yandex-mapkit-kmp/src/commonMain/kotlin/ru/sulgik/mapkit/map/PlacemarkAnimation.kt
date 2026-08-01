package ru.sulgik.mapkit.map

/**
 * Controls the animation of a placemark.
 */
public expect class PlacemarkAnimation : PlacemarkPresentation {

    /**
     * If true, animation will be played in the reverse direction.
     */
    public var isReversed: Boolean

    /**
     * Sets the animated image and icon style.
     *
     * @param onFinished Called when the image is applied.
     */
    public fun setIcon(
        image: AnimatedImageProvider,
        style: IconStyle,
        onFinished: Callback? = null,
    )

    /**
     * Changes the icon style.
     */
    public fun setIconStyle(style: IconStyle)

    /**
     * Starts animation.
     *
     * @param onFinished Called when the animation is finished.
     */
    public fun play(onFinished: Callback? = null)

    /**
     * Resumes paused animation.
     */
    public fun resume()

    /**
     * Stops animation.
     */
    public fun stop()

    /**
     * Pauses animation.
     */
    public fun pause()
}
