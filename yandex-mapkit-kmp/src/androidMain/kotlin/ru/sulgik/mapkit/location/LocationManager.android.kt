package ru.sulgik.mapkit.location

import kotlin.time.Duration
import com.yandex.mapkit.location.LocationManager as NativeLocationManager

public actual class LocationManager(private val nativeLocationManager: NativeLocationManager) {

    public fun toNative(): NativeLocationManager {
        return nativeLocationManager
    }

    public actual fun subscribeForLocationUpdates(
        desiredAccuracy: Double,
        minTime: Duration,
        minDistance: Double,
        allowUseInBackground: Boolean,
        filteringMode: FilteringMode,
        locationListener: LocationListener,
    ) {
        nativeLocationManager.subscribeForLocationUpdates(
            desiredAccuracy,
            minTime.inWholeMilliseconds,
            minDistance,
            allowUseInBackground,
            filteringMode.toNative(),
            locationListener.toNative()
        )
    }

    public actual fun suspend() {
        nativeLocationManager.suspend()
    }

    public actual fun resume() {
        nativeLocationManager.resume()
    }

    public actual fun requestSingleUpdate(locationListener: LocationListener) {
        nativeLocationManager.requestSingleUpdate(locationListener.toNative())
    }

    public actual fun unsubscribe(locationListener: LocationListener) {
        nativeLocationManager.unsubscribe(locationListener.toNative())
    }

}

public fun NativeLocationManager.toCommon(): LocationManager {
    return LocationManager(this)
}