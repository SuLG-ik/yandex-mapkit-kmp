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
     * Left untouched when null: the value is applied only while it is not null, and setting it
     * back to null does not restore the map's default.
     */
    val minZoomPreference: Float? = null,
    /**
     * Maximum available zoom level hint via [CameraBounds.setMaxZoomPreference].
     *
     * Left untouched when null: the value is applied only while it is not null, and setting it
     * back to null does not restore the map's default.
     */
    val maxZoomPreference: Float? = null,
    /**
     * Bounding box the camera is limited to via [CameraBounds.latLngBounds].
     *
     * Latitudes should be in range [-89.3, 89.3], longitudes in range [-180, 180).
     *
     * Left untouched when null: the value is applied only while it is not null, and setting it
     * back to null does not restore the map's default.
     */
    val latLngBounds: BoundingBox? = null,
)
