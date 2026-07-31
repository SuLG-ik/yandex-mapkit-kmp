package ru.sulgik.mapkit.location

/**
 * The area the user is looking at.
 */
public data class ViewArea(
    /**
     * The length of the view area in meters.
     */
    val lengthwise: Double,
    /**
     * The width of the view area from center in meters.
     */
    val transverse: Double,
)
