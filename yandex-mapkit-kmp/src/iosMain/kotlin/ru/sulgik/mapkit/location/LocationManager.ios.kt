package ru.sulgik.mapkit.location

import kotlin.time.Duration
import YandexMapKit.YMKLocationManager as NativeLocationManager

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
        purpose: LocationPurpose,
        locationListener: LocationListener,
    ) {
        nativeLocationManager.subscribeForLocationUpdatesWithDesiredAccuracy(
            desiredAccuracy = desiredAccuracy,
            minTime = minTime.inWholeMilliseconds,
            minDistance = minDistance,
            allowUseInBackground = allowUseInBackground,
            filteringMode = filteringMode.toNative(),
            purpose = purpose.toNative(),
            locationListener = locationListener.toNative(),
        )
    }

    public actual fun suspend() {
        nativeLocationManager.suspend()
    }

    public actual fun resume() {
        nativeLocationManager.resume()
    }

    public actual fun requestSingleUpdate(locationListener: LocationListener) {
        nativeLocationManager.requestSingleUpdateWithLocationListener(locationListener.toNative())
    }

    public actual fun unsubscribe(locationListener: LocationListener) {
        nativeLocationManager.unsubscribeWithLocationListener(locationListener.toNative())
    }

}

public fun NativeLocationManager.toCommon(): LocationManager {
    return LocationManager(this)
}