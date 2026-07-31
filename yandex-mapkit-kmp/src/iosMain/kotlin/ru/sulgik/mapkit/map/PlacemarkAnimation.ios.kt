package ru.sulgik.mapkit.map

import YandexMapKit.YMKPlacemarkAnimation as NativePlacemarkAnimation

/**
 * Controls the animation of a placemark.
 */
public actual class PlacemarkAnimation internal constructor(
    private val nativePlacemarkAnimation: NativePlacemarkAnimation,
) : PlacemarkPresentation(nativePlacemarkAnimation) {

    override fun toNative(): NativePlacemarkAnimation {
        return nativePlacemarkAnimation
    }

    /**
     * If true, animation will be played in the reverse direction.
     */
    public actual var isReversed: Boolean
        get() = nativePlacemarkAnimation.reversed
        set(value) {
            nativePlacemarkAnimation.reversed = value
        }

    /**
     * Sets the animated image and icon style.
     *
     * @param onFinished Called when the image is applied.
     */
    public actual fun setIcon(
        image: AnimatedImageProvider,
        style: IconStyle,
        onFinished: Callback?,
    ) {
        if (onFinished != null) {
            nativePlacemarkAnimation.setIconWithImage(
                image.toNative(),
                style.toNative(),
                onFinished.toNative(),
            )
        } else {
            nativePlacemarkAnimation.setIconWithImage(image.toNative(), style.toNative())
        }
    }

    /**
     * Changes the icon style.
     */
    public actual fun setIconStyle(style: IconStyle) {
        nativePlacemarkAnimation.setIconStyleWithStyle(style.toNative())
    }

    /**
     * Starts animation.
     *
     * @param onFinished Called when the animation is finished.
     */
    public actual fun play(onFinished: Callback?) {
        if (onFinished != null) {
            nativePlacemarkAnimation.playWithCallback(onFinished.toNative())
        } else {
            nativePlacemarkAnimation.play()
        }
    }

    /**
     * Resumes paused animation.
     */
    public actual fun resume() {
        nativePlacemarkAnimation.resume()
    }

    /**
     * Stops animation.
     */
    public actual fun stop() {
        nativePlacemarkAnimation.stop()
    }

    /**
     * Pauses animation.
     */
    public actual fun pause() {
        nativePlacemarkAnimation.pause()
    }
}

public fun NativePlacemarkAnimation.toCommon(): PlacemarkAnimation {
    return PlacemarkAnimation(this)
}
