package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.map.CameraBounds as NativeCameraBounds

public actual class CameraBounds internal constructor(
    private val nativeCameraBounds: NativeCameraBounds,
) {

    public fun toNative(): NativeCameraBounds {
        return nativeCameraBounds
    }

    /**
     * Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference.
     */
    public actual val minZoom: Float
        get() = nativeCameraBounds.minZoom

    /**
     * Maximum available zoom level considering zoom level hint provided via #setMinZoomPreference.
     */
    public actual val maxZoom: Float
        get() = nativeCameraBounds.maxZoom

    /**
     * Latitudes should be in range [-89.3, 89.3].
     *
     * Longitudes should be in range [-180, 180).
     */
    public actual var latLngBounds: BoundingBox?
        get() = nativeCameraBounds.latLngBounds?.toCommon()
        set(value) {
            nativeCameraBounds.latLngBounds = value?.toNative()
        }

    /**
     * Reset minimum and maximum available zoom level hints.
     */
    public actual fun resetMinMaxZoomPreference() {
        nativeCameraBounds.resetMinMaxZoomPreference()
    }

    /**
     * Set minimum available zoom level hint.
     */
    public actual fun setMinZoomPreference(zoom: Float) {
        nativeCameraBounds.setMinZoomPreference(zoom)
    }

    /**
     * Set maximum available zoom level hint.
     */
    public actual fun setMaxZoomPreference(zoom: Float) {
        nativeCameraBounds.setMaxZoomPreference(zoom)
    }

}

public fun NativeCameraBounds.toCommon(): CameraBounds {
    return CameraBounds(this)
}