package ru.sulgik.mapkit.map

import kotlin.time.Duration

/**
 * How long it took the map to render everything that is visible.
 */
public data class MapLoadStatistics(
    val curZoomGeometryLoaded: Duration,
    val curZoomPlacemarksLoaded: Duration,
    val curZoomLabelsLoaded: Duration,
    /**
     * The time it took to load delayed geometry.
     */
    val delayedGeometryLoaded: Duration,
    /**
     * The time it took to load models.
     */
    val curZoomModelsLoaded: Duration,
    /**
     * The time it took to load all map objects.
     */
    val fullyLoaded: Duration,
    /**
     * The time it took for all map objects to appear.
     */
    val fullyAppeared: Duration,
    val renderObjectCount: Int,
    /**
     * Tile memory usage in bytes.
     */
    val tileMemoryUsage: Int,
)
