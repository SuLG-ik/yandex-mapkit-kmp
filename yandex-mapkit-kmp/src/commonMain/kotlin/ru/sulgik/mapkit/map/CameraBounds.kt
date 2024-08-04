package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.BoundingBox

public expect class CameraBounds {

    /**
     * Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference.
     */
    public val minZoom: Float

    /**
     * Maximum available zoom level considering zoom level hint provided via #setMinZoomPreference.
     */
    public val maxZoom: Float

    /**
     * Latitudes should be in range [-89.3, 89.3].
     *
     * Longitudes should be in range [-180, 180).
     */
    public var latLngBounds: BoundingBox?

    /**
     * Reset minimum and maximum available zoom level hints.
     */
    public fun resetMinMaxZoomPreference()

    /**
     * Set minimum available zoom level hint.
     */
    public fun setMinZoomPreference(zoom: Float)

    /**
     * Set maximum available zoom level hint.
     */
    public fun setMaxZoomPreference(zoom: Float)

}