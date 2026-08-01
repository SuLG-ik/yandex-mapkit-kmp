package ru.sulgik.mapkit.map

import kotlin.time.Duration
import YandexMapKit.YRTAnimatedImage as NativeAnimatedImage
import YandexMapKit.YRTFrame as NativeFrame

/**
 * An animation assembled frame by frame.
 */
public actual class AnimatedImage internal constructor(
    private val nativeAnimatedImage: NativeAnimatedImage,
) {

    public actual constructor(loopCount: Int) : this(NativeAnimatedImage(loopCount))

    public fun toNative(): NativeAnimatedImage {
        return nativeAnimatedImage
    }

    /**
     * The number of animation loops.
     */
    public actual val loopCount: Int
        get() = nativeAnimatedImage.loopCount()

    /**
     * The animation frames.
     */
    @Suppress("UNCHECKED_CAST")
    public actual val frames: List<Frame>
        get() = (nativeAnimatedImage.frames() as List<NativeFrame>).map { it.toCommon() }

    /**
     * Appends a frame to the animation.
     */
    public actual fun addFrame(image: ImageProvider, duration: Duration) {
        nativeAnimatedImage.addFrameWithImage(image.toNative(), duration.inWholeMilliseconds / 1000.0)
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AnimatedImage) return false
        if (this::class != other::class) return false
        return nativeAnimatedImage == other.nativeAnimatedImage
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeAnimatedImage.hashCode()
    }
}

public fun NativeAnimatedImage.toCommon(): AnimatedImage {
    return AnimatedImage(this)
}
