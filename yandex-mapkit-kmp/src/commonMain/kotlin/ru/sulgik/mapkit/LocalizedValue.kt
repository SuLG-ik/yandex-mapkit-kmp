package ru.sulgik.mapkit

/**
 * A value with its localized description.
 */
public data class LocalizedValue(
    /**
     * Value in SI units for distance, speed and duration.
     */
    val value: Double,
    /**
     * Localized text.
     */
    val text: String,
)
