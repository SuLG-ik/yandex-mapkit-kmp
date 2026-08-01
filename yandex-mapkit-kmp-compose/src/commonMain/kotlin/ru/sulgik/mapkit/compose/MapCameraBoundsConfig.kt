package ru.sulgik.mapkit.compose

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.map.CameraBounds
import ru.sulgik.mapkit.map.Map

/**
 * Config to control zoom limits and the world bounding box with [Map.cameraBounds]
 */
public data class MapCameraBoundsConfig(
    /**
     * Minimum available zoom level hint via [CameraBounds.setMinZoomPreference].
     *
     * If null use map's default value
     */
    val minZoomPreference: Float? = null,
    /**
     * Maximum available zoom level hint via [CameraBounds.setMaxZoomPreference].
     *
     * If null use map's default value
     */
    val maxZoomPreference: Float? = null,
    /**
     * Bounding box the camera is limited to via [CameraBounds.latLngBounds].
     *
     * Latitudes should be in range [-89.3, 89.3], longitudes in range [-180, 180).
     *
     * If null use map's default value
     */
    val latLngBounds: BoundingBox? = null,
)
