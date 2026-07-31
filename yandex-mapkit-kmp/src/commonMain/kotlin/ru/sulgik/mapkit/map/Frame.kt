package ru.sulgik.mapkit.map

import kotlin.time.Duration

/**
 * A single frame of an [AnimatedImage].
 */
public data class Frame(
    /**
     * A provider of the frame image.
     */
    val image: ImageProvider,
    /**
     * How long the image is displayed.
     */
    val duration: Duration,
)
