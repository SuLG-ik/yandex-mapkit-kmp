package ru.sulgik.mapkit.map

import kotlin.time.Duration
import com.yandex.runtime.image.AnimatedImage as NativeAnimatedImage

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
        get() = nativeAnimatedImage.loopCount

    /**
     * The animation frames.
     */
    public actual val frames: List<Frame>
        get() = nativeAnimatedImage.frames.map { it.toCommon() }

    /**
     * Appends a frame to the animation.
     */
    public actual fun addFrame(image: ImageProvider, duration: Duration) {
        nativeAnimatedImage.addFrame(image.toNative(), duration.inWholeMilliseconds)
    }
}

public fun NativeAnimatedImage.toCommon(): AnimatedImage {
    return AnimatedImage(this)
}
