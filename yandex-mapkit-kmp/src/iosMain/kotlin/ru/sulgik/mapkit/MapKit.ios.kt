@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit

import YandexMapKit.setApiKey
import YandexMapKit.setLocale
import YandexMapKit.setUserId
import YandexMapKit.sharedInstance
import kotlinx.cinterop.ExperimentalForeignApi
import ru.sulgik.mapkit.location.LocationManager
import ru.sulgik.mapkit.location.toCommon
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.user_location.UserLocationLayer
import ru.sulgik.mapkit.user_location.toCommon
import YandexMapKit.YMKMapKit as NativeMapKit

public actual class MapKit internal constructor(private val nativeMapKit: NativeMapKit) {

    public fun toNative(): NativeMapKit {
        return nativeMapKit

    }

    /**
     * Returns the version of the MapKit bundle.
     */
    public actual val version: String
        get() = nativeMapKit.version

    /**
     * Resets the global location manager to a default one, that is a location manager that is created by createLocationManager() call.
     */
    public actual fun resetLocationManagerToDefault() {
        nativeMapKit.resetLocationManagerToDefault()
    }

    /**
     * Notifies MapKit when the application resumes the foreground state.
     */
    public actual fun onStart() {
        nativeMapKit.onStart()
    }

    /**
     * Notifies MapKit when the application pauses and goes to the background.
     */
    public actual fun onStop() {
        nativeMapKit.onStop()
    }

    /**
     * Sets single global location manager that is used by every module in MapKit by default.
     */
    public actual fun setLocationManager(locationManager: LocationManager) {
        nativeMapKit.setLocationManagerWithLocationManager(locationManager.toNative())
    }

    /**
     * Creates a manager that allows to listen for device location updates.
     */
    public actual fun createLocationManager(): LocationManager {
        return nativeMapKit.createLocationManager().toCommon()
    }

    /**
     * Create layer with the user location icon.
     */
    public actual fun createUserLocationLayer(mapWindow: MapWindow): UserLocationLayer {
        return nativeMapKit.createUserLocationLayerWithMapWindow(mapWindow.toNative()).toCommon()
    }

    public actual companion object {
        public actual fun setApiKey(apiKey: String) {
            NativeMapKit.setApiKey(apiKey)
        }

        public actual fun getInstance(): MapKit {
            return NativeMapKit.sharedInstance().toCommon()
        }

        public actual fun setLocale(locale: String?) {
            NativeMapKit.setLocale(locale)
        }

        public actual fun setUserId(userId: String) {
            NativeMapKit.setUserId(userId)
        }
    }
}

public fun NativeMapKit.toCommon(): MapKit {
    return MapKit(this)
}