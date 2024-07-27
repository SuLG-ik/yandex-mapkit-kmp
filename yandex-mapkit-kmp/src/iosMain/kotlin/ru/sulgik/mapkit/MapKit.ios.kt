@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit

import YandexMapKit.setApiKey
import YandexMapKit.setLocale
import YandexMapKit.setUserId
import YandexMapKit.sharedInstance
import kotlinx.cinterop.ExperimentalForeignApi
import ru.sulgik.mapkit.location.LocationManager
import ru.sulgik.mapkit.location.toCommon
import ru.sulgik.runtime.sensors.LocationActivityType
import ru.sulgik.runtime.sensors.toNative
import YandexMapKit.YMKMapKit as NativeMapKit

actual class MapKit internal constructor(private val nativeMapKit: NativeMapKit) {

    fun toNative(): NativeMapKit {
        return nativeMapKit

    }

    /**
     * Returns the version of the MapKit bundle.
     */
    actual val version: String
        get() = nativeMapKit.version

    /**
     * Resets the global location manager to a default one, that is a location manager that is created by createLocationManager() call.
     */
    actual fun resetLocationManagerToDefault() {
        nativeMapKit.resetLocationManagerToDefault()
    }

    /**
     * Notifies MapKit when the application resumes the foreground state.
     */
    actual fun onStart() {
        nativeMapKit.onStart()
    }

    /**
     * Notifies MapKit when the application pauses and goes to the background.
     */
    actual fun onStop() {
        nativeMapKit.onStop()
    }

    /**
     * Sets single global location manager that is used by every module in MapKit by default.
     */
    actual fun setLocationManager(locationManager: LocationManager) {
        nativeMapKit.setLocationManagerWithLocationManager(locationManager.toNative())
    }

    /**
     * Creates a manager that allows to listen for device location updates.
     */
    actual fun createLocationManager(): LocationManager {
        return nativeMapKit.createLocationManager().toCommon()
    }

    /**
     * Creates a manager that allows to listen for device location updates, uses activityType as a hint.
     */
    actual fun createLocationManager(activityType: LocationActivityType): LocationManager {
        return nativeMapKit.createLocationManagerWithActivityType(activityType.toNative())
            .toCommon()
    }

    actual companion object {
        actual fun setApiKey(apiKey: String) {
            NativeMapKit.setApiKey(apiKey)
        }

        actual fun getInstance(): MapKit {
            return NativeMapKit.sharedInstance().toCommon()
        }

        actual fun setLocale(locale: String?) {
            NativeMapKit.setLocale(locale)
        }

        actual fun setUserId(userId: String) {
            NativeMapKit.setUserId(userId)
        }
    }
}

fun NativeMapKit.toCommon(): MapKit {
    return MapKit(this)
}