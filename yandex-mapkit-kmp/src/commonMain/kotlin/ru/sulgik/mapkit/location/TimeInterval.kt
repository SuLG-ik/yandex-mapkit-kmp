package ru.sulgik.mapkit.location

import kotlin.time.Duration

/**
 * An interval of time.
 */
public data class TimeInterval(
    /**
     * Lower limit.
     */
    val from: Duration,
    /**
     * Upper limit.
     */
    val to: Duration,
)
