package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.toNSData
import YandexMapKit.YRTAnimatedImageProviderFactory as NativeAnimatedImageProviderFactory
import YandexMapKit.YRTAnimatedImageProviderProtocol as NativeAnimatedImageProvider

/**
 * Provides an animated image to MapKit.
 *
 * The animation data itself is opaque; instances come from the [Companion] factories.
 */
public actual interface AnimatedImageProvider {

    public fun toNative(): NativeAnimatedImageProvider

    public actual companion object {

        /**
         * Returns an animated image provider based on the given data.
         */
        public actual fun fromByteArray(image: ByteArray): AnimatedImageProvider {
            return (NativeAnimatedImageProviderFactory.fromData(image.toNSData()) as NativeAnimatedImageProvider).toCommon()
        }

        /**
         * Returns an animated image provider based on an image file from the internal storage.
         */
        public actual fun fromFile(fileName: String): AnimatedImageProvider {
            return (NativeAnimatedImageProviderFactory.fromFile(fileName) as NativeAnimatedImageProvider).toCommon()
        }

        /**
         * Returns an animated image provider based on the frames of [image].
         */
        public actual fun fromAnimatedImage(image: AnimatedImage): AnimatedImageProvider {
            return (NativeAnimatedImageProviderFactory.fromAnimatedImage(image.toNative()) as NativeAnimatedImageProvider).toCommon()
        }
    }
}

public class IOSAnimatedImageProvider internal constructor(
    private val nativeAnimatedImageProvider: NativeAnimatedImageProvider,
) : AnimatedImageProvider {

    override fun toNative(): NativeAnimatedImageProvider {
        return nativeAnimatedImageProvider
    }
}

public fun NativeAnimatedImageProvider.toCommon(): AnimatedImageProvider {
    return IOSAnimatedImageProvider(this)
}
