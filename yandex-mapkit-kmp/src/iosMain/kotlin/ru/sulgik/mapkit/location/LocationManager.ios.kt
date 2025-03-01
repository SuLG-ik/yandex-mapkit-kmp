package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationManager as NativeLocationManager

public actual class LocationManager(private val nativeLocationManager: NativeLocationManager) {

    public fun toNative(): NativeLocationManager {
        return nativeLocationManager
    }

    public actual fun subscribeForLocationUpdates(
        subscriptionSettings: SubscriptionSettings,
        locationListener: LocationListener,
    ) {
        nativeLocationManager.subscribeForLocationUpdatesWithSubscriptionSettings(
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
        nativeLocationManager.requestSingleUpdateWithLocationListener(locationListener.toNative())
    }

    public actual fun unsubscribe(locationListener: LocationListener) {
        nativeLocationManager.unsubscribeWithLocationListener(locationListener.toNative())
    }

}

public fun NativeLocationManager.toCommon(): LocationManager {
    return LocationManager(this)
}