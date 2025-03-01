package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.LocationManager as NativeLocationManager

public actual class LocationManager(private val nativeLocationManager: NativeLocationManager) {

    public fun toNative(): NativeLocationManager {
        return nativeLocationManager
    }

    public actual fun subscribeForLocationUpdates(
        subscriptionSettings: SubscriptionSettings,
        locationListener: LocationListener,
    ) {
        nativeLocationManager.subscribeForLocationUpdates(
            subscriptionSettings.toNative(),
            locationListener.toNative(),
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