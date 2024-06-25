package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKCameraBounds as NativeCameraBounds

actual class CameraBounds internal constructor(private val nativeCameraBounds: NativeCameraBounds) {

    fun toNative(): NativeCameraBounds {
        return nativeCameraBounds
    }

    /**
     * Minimum available zoom level considering zoom level hint provided via #setMinZoomPreference.
     */
    actual val minZoom: Float
        get() = nativeCameraBounds.getMinZoom()

    /**
     * Maximum available zoom level considering zoom level hint provided via #setMinZoomPreference.
     */
    actual val maxZoom: Float
        get() = nativeCameraBounds.getMaxZoom()

    /**
     * Latitudes should be in range [-89.3, 89.3].
     *
     * Longitudes should be in range [-180, 180).
     */
    actual var latLngBounds: BoundingBox?
        get() = nativeCameraBounds.latLngBounds?.toCommon()
        set(value) {
            nativeCameraBounds.latLngBounds = value?.toNative()
        }

    /**
     * Reset minimum and maximum available zoom level hints.
     */
    actual fun resetMinMaxZoomPreference() {
        nativeCameraBounds.resetMinMaxZoomPreference()
    }

    /**
     * Set minimum available zoom level hint.
     */
    actual fun setMinZoomPreference(zoom: Float) {
        nativeCameraBounds.setMinZoomPreferenceWithZoom(zoom)
    }

    /**
     * Set maximum available zoom level hint.
     */
    actual fun setMaxZoomPreference(zoom: Float) {
        nativeCameraBounds.setMaxZoomPreferenceWithZoom(zoom)
    }

}

fun NativeCameraBounds.toCommon(): CameraBounds {
    return CameraBounds(this)
}