package ru.sulgik.mapkit

import android.content.Context
import com.yandex.mapkit.MapKitFactory
import ru.sulgik.mapkit.location.LocationManager
import ru.sulgik.mapkit.location.toCommon
import ru.sulgik.runtime.sensors.LocationActivityType
import ru.sulgik.runtime.sensors.toNative
import com.yandex.mapkit.MapKit as NativeMapKit

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
        nativeMapKit.setLocationManager(locationManager.toNative())
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
        return nativeMapKit.createLocationManager(activityType.toNative()).toCommon()
    }

    actual companion object {

        fun initialize(context: Context) {
            MapKitFactory.initialize(context)
        }

        actual fun setApiKey(apiKey: String) {
            MapKitFactory.setApiKey(apiKey)
        }

        actual fun getInstance(): MapKit {
            return MapKitFactory.getInstance().toCommon()
        }

        actual fun setLocale(locale: String?) {
            MapKitFactory.setLocale(locale)
        }

        actual fun setUserId(userId: String) {
            MapKitFactory.setUserId(userId)
        }
    }
}

fun NativeMapKit.toCommon(): MapKit {
    return MapKit(this)
}
