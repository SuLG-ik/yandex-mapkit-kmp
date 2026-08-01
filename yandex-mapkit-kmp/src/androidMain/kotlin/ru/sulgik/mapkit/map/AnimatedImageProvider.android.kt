package ru.sulgik.mapkit.map

import android.content.Context
import androidx.annotation.DrawableRes
import com.yandex.runtime.image.AnimatedImageProvider as NativeAnimatedImageProvider

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
            return NativeAnimatedImageProvider.fromByteArray(image).toCommon()
        }

        /**
         * Returns an animated image provider based on an image file from the internal storage.
         */
        public actual fun fromFile(fileName: String): AnimatedImageProvider {
            return NativeAnimatedImageProvider.fromFile(fileName).toCommon()
        }

        /**
         * Returns an animated image provider based on the frames of [image].
         */
        public actual fun fromAnimatedImage(image: AnimatedImage): AnimatedImageProvider {
            return NativeAnimatedImageProvider.fromAnimatedImage(image.toNative()).toCommon()
        }

        /**
         * Returns an animated image provider based on a given resource.
         */
        public fun fromResource(context: Context, @DrawableRes resourceId: Int): AnimatedImageProvider {
            return NativeAnimatedImageProvider.fromResource(context, resourceId).toCommon()
        }

        /**
         * Returns an animated image provider based on a given asset (from the assets/ directory).
         */
        public fun fromAsset(context: Context, assetName: String): AnimatedImageProvider {
            return NativeAnimatedImageProvider.fromAsset(context, assetName).toCommon()
        }
    }
}

public class AndroidAnimatedImageProvider internal constructor(
    private val nativeAnimatedImageProvider: NativeAnimatedImageProvider,
) : AnimatedImageProvider {

    override fun toNative(): NativeAnimatedImageProvider {
        return nativeAnimatedImageProvider
    }
}

public fun NativeAnimatedImageProvider.toCommon(): AnimatedImageProvider {
    return AndroidAnimatedImageProvider(this)
}
