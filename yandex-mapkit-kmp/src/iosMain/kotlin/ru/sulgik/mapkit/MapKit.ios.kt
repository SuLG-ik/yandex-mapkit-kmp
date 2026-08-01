@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit

import YandexMapKit.setApiKey
import YandexMapKit.setLocale
import YandexMapKit.setUserId
import YandexMapKit.sharedInstance
import kotlinx.cinterop.ExperimentalForeignApi
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.location.DummyLocationManager
import ru.sulgik.mapkit.location.LocationManager
import ru.sulgik.mapkit.location.LocationSimulator
import ru.sulgik.mapkit.location.toCommon
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.offline_cache.OfflineCacheManager
import ru.sulgik.mapkit.offline_cache.toCommon
import ru.sulgik.mapkit.storage.StorageManager
import ru.sulgik.mapkit.storage.toCommon
import ru.sulgik.mapkit.traffic.TrafficLayer
import ru.sulgik.mapkit.traffic.toCommon
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
     * Notifies MapKit when the application will terminate.
     */
    public actual fun onTerminate() {
        nativeMapKit.onTerminate()
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

    /**
     * Creates a suspended [LocationSimulator] object, optionally with the given geometry.
     */
    public actual fun createLocationSimulator(geometry: Polyline?): LocationSimulator {
        return if (geometry != null) {
            nativeMapKit.createLocationSimulatorWithGeometry(geometry.toNative())
        } else {
            nativeMapKit.createLocationSimulator()
        }.toCommon()
    }

    /**
     * Creates a manager that functions as a location proxy.
     */
    public actual fun createDummyLocationManager(): DummyLocationManager {
        return nativeMapKit.createDummyLocationManager().toCommon()
    }

    /**
     * Creates the traffic layer for the given map window.
     */
    public actual fun createTrafficLayer(mapWindow: MapWindow): TrafficLayer {
        return nativeMapKit.createTrafficLayerWithMapWindow(mapWindow.toNative()).toCommon()
    }

    /**
     * Manages the space MapKit occupies on the device.
     */
    public actual val storageManager: StorageManager
        get() = nativeMapKit.storageManager.toCommon()

    /**
     * Downloads and manages the offline maps.
     */
    public actual val offlineCacheManager: OfflineCacheManager
        get() = nativeMapKit.offlineCacheManager.toCommon()

    /**
     * Tells if this **MapKit** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeMapKit.isValid()

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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MapKit) return false
        if (this::class != other::class) return false
        return nativeMapKit == other.nativeMapKit
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeMapKit.hashCode()
    }
}

public fun NativeMapKit.toCommon(): MapKit {
    return MapKit(this)
}
