package ru.sulgik.mapkit.location

import kotlin.time.Duration
import YandexMapKit.YMKLocationManager as NativeLocationManager

actual class LocationManager(private val nativeLocationManager: NativeLocationManager) {

    fun toNative(): NativeLocationManager {
        return nativeLocationManager
    }

    actual fun subscribeForLocationUpdates(
        desiredAccuracy: Double,
        minTime: Duration,
        minDistance: Double,
        allowUseInBackground: Boolean,
        filteringMode: FilteringMode,
        locationListener: LocationListener,
    ) {
        nativeLocationManager.subscribeForLocationUpdatesWithDesiredAccuracy(
            desiredAccuracy = desiredAccuracy,
            minTime = minTime.inWholeMilliseconds,
            minDistance = minDistance,
            allowUseInBackground = allowUseInBackground,
            filteringMode = filteringMode.toNative(),
            locationListener = locationListener.toNative(),
        )
    }

    actual fun suspend() {
        nativeLocationManager.suspend()
    }

    actual fun resume() {
        nativeLocationManager.resume()
    }

    actual fun requestSingleUpdate(locationListener: LocationListener) {
        nativeLocationManager.requestSingleUpdateWithLocationListener(locationListener.toNative())
    }

    actual fun unsubscribe(locationListener: LocationListener) {
        nativeLocationManager.unsubscribeWithLocationListener(locationListener.toNative())
    }

}

fun NativeLocationManager.toCommon(): LocationManager {
    return LocationManager(this)
}