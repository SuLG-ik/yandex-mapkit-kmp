package ru.sulgik.mapkit

/**
 * The range of zoom levels a data source covers.
 */
public data class ZoomRange(
    /**
     * Lower limit of zoom range, inclusive.
     */
    val zMin: Int,
    /**
     * Upper limit of zoom range, exclusive.
     */
    val zMax: Int,
)
