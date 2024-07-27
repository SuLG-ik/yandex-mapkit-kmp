package ru.sulgik.mapkit.location

import kotlin.time.Duration
import com.yandex.mapkit.location.LocationManager as NativeLocationManager

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
        nativeLocationManager.subscribeForLocationUpdates(
            desiredAccuracy,
            minTime.inWholeMilliseconds,
            minDistance,
            allowUseInBackground,
            filteringMode.toNative(),
            locationListener
        )
    }

    actual fun suspend() {
        nativeLocationManager.suspend()
    }

    actual fun resume() {
        nativeLocationManager.resume()
    }

    actual fun requestSingleUpdate(locationListener: LocationListener) {
        nativeLocationManager.requestSingleUpdate(locationListener)
    }

    actual fun unsubscribe(locationListener: LocationListener) {
        nativeLocationManager.unsubscribe(locationListener)
    }

}

fun NativeLocationManager.toCommon(): LocationManager {
    return LocationManager(this)
}