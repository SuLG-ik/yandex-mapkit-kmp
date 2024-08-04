package ru.sulgik.mapkit

import android.content.Context
import com.yandex.mapkit.MapKitFactory
import ru.sulgik.mapkit.location.LocationManager
import ru.sulgik.mapkit.location.toCommon
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.user_location.UserLocationLayer
import ru.sulgik.mapkit.user_location.toCommon
import ru.sulgik.runtime.sensors.LocationActivityType
import ru.sulgik.runtime.sensors.toNative
import com.yandex.mapkit.MapKit as NativeMapKit

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
        nativeMapKit.setLocationManager(locationManager.toNative())
    }

    /**
     * Creates a manager that allows to listen for device location updates.
     */
    public actual fun createLocationManager(): LocationManager {
        return nativeMapKit.createLocationManager().toCommon()
    }

    /**
     * Creates a manager that allows to listen for device location updates, uses activityType as a hint.
     */
    public actual fun createLocationManager(activityType: LocationActivityType): LocationManager {
        return nativeMapKit.createLocationManager(activityType.toNative()).toCommon()
    }

    /**
     * Create layer with the user location icon.
     */
    public actual fun createUserLocationLayer(mapWindow: MapWindow): UserLocationLayer {
        return nativeMapKit.createUserLocationLayer(mapWindow.toNative()).toCommon()
    }

    public actual companion object {

        public fun initialize(context: Context) {
            MapKitFactory.initialize(context)
        }

        public actual fun setApiKey(apiKey: String) {
            MapKitFactory.setApiKey(apiKey)
        }

        public actual fun getInstance(): MapKit {
            return MapKitFactory.getInstance().toCommon()
        }

        public actual fun setLocale(locale: String?) {
            MapKitFactory.setLocale(locale)
        }

        public actual fun setUserId(userId: String) {
            MapKitFactory.setUserId(userId)
        }
    }
}

public fun NativeMapKit.toCommon(): MapKit {
    return MapKit(this)
}
