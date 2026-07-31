package ru.sulgik.mapkit.location

/**
 * How far the simulated locations may deviate from the route.
 */
public data class LocationError(
    /**
     * The error of spreading locations across the route.
     */
    val lateralErrorRange: Range,
    /**
     * The error of spreading locations along the route.
     */
    val longitudinalErrorRange: Range,
)
