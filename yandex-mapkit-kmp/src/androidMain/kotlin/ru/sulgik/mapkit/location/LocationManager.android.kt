package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.location.LocationManager as NativeLocationManager

public actual class LocationManager(private val nativeLocationManager: NativeLocationManager) {

    public fun toNative(): NativeLocationManager {
        return nativeLocationManager
    }

    public actual fun subscribeForLocationUpdates(
        subscriptionSettings: SubscriptionSettings,
        locationListener: WeakRef<LocationListener>,
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

    public actual fun requestSingleUpdate(locationListener: WeakRef<LocationListener>) {
        nativeLocationManager.requestSingleUpdate(locationListener.toNative())
    }

    public actual fun unsubscribe(locationListener: WeakRef<LocationListener>) {
        nativeLocationManager.unsubscribe(locationListener.toNative())
    }

}

public fun NativeLocationManager.toCommon(): LocationManager {
    return LocationManager(this)
}