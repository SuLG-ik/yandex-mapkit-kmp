package ru.sulgik.mapkit.traffic

/**
 * How busy the roads currently are.
 */
public data class TrafficLevel(
    /**
     * The color that represents traffic.
     */
    val color: TrafficColor,
    /**
     * Traffic level.
     */
    val level: Int,
)
