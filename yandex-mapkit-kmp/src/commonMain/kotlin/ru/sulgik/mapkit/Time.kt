package ru.sulgik.mapkit

/**
 * A moment in time with its localized description.
 */
public data class Time(
    /**
     * Time value.
     */
    val value: Long,
    /**
     * Time offset to account for time zones.
     */
    val tzOffset: Int,
    /**
     * The description of the timer.
     */
    val text: String,
)
