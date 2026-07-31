package ru.sulgik.mapkit.map

import kotlin.time.Duration

/**
 * An animation assembled frame by frame.
 */
public expect class AnimatedImage(loopCount: Int) {

    /**
     * The number of animation loops.
     */
    public val loopCount: Int

    /**
     * The animation frames.
     */
    public val frames: List<Frame>

    /**
     * Appends a frame to the animation.
     */
    public fun addFrame(image: ImageProvider, duration: Duration)
}
