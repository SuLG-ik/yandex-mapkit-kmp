package ru.sulgik.mapkit.map

/**
 * Provides an animated image to MapKit.
 *
 * The animation data itself is opaque; instances come from the [Companion] factories.
 */
public expect interface AnimatedImageProvider {

    public companion object {

        /**
         * Returns an animated image provider based on the given data.
         */
        public fun fromByteArray(image: ByteArray): AnimatedImageProvider

        /**
         * Returns an animated image provider based on an image file from the internal storage.
         */
        public fun fromFile(fileName: String): AnimatedImageProvider

        /**
         * Returns an animated image provider based on the frames of [image].
         */
        public fun fromAnimatedImage(image: AnimatedImage): AnimatedImageProvider
    }
}
