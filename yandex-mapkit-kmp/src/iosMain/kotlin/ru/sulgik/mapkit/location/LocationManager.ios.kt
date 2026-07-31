package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKLocationManager as NativeLocationManager

public actual class LocationManager(private val nativeLocationManager: NativeLocationManager) {

    public fun toNative(): NativeLocationManager {
        return nativeLocationManager
    }

    public actual fun subscribeForLocationUpdates(
        subscriptionSettings: SubscriptionSettings,
        locationListener: WeakRef<LocationListener>,
    ) {
        nativeLocationManager.subscribeForLocationUpdatesWithSubscriptionSettings(
            subscriptionSettings.toNative(),
            locationListener.toNative() ?: return,
        )
    }

    public actual fun suspend() {
        nativeLocationManager.suspend()
    }

    public actual fun resume() {
        nativeLocationManager.resume()
    }

    public actual fun requestSingleUpdate(locationListener: WeakRef<LocationListener>) {
        nativeLocationManager.requestSingleUpdateWithLocationListener(locationListener.toNative() ?: return)
    }

    public actual fun unsubscribe(locationListener: WeakRef<LocationListener>) {
        nativeLocationManager.unsubscribeWithLocationListener(locationListener.toNative() ?: return)
    }

}

public fun NativeLocationManager.toCommon(): LocationManager {
    return LocationManager(this)
}