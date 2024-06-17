package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.BoundingBox

expect class CameraBounds {

    /**
     * Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference.
     */
    val minZoom: Float

    /**
     * Maximum available zoom level considering zoom level hint provided via #setMinZoomPreference.
     */
    val maxZoom: Float

    /**
     * Latitudes should be in range [-89.3, 89.3].
     *
     * Longitudes should be in range [-180, 180).
     */
    var latLngBounds: BoundingBox?

    /**
     * Reset minimum and maximum available zoom level hints.
     */
    fun resetMinMaxZoomPreference()

    /**
     * Set minimum available zoom level hint.
     */
    fun setMinZoomPreference(zoom: Float)

    /**
     * Set maximum available zoom level hint.
     */
    fun setMaxZoomPreference(zoom: Float)

}