package ru.sulgik.mapkit.runtime.i18n

/**
 * A value with the unit of measurement kept separate.
 */
public data class CanonicalUnit(
    /**
     * The unit of measurement.
     */
    val unit: String,
    /**
     * The numerical value.
     */
    val value: Double,
)
