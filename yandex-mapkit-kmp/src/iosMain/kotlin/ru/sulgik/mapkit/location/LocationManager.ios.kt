package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKLocationManager as NativeLocationManager

public actual class LocationManager internal constructor(private val nativeLocationManager: NativeLocationManager) {

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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LocationManager) return false
        if (this::class != other::class) return false
        return nativeLocationManager == other.nativeLocationManager
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeLocationManager.hashCode()
    }
}

public fun NativeLocationManager.toCommon(): LocationManager {
    return LocationManager(this)
}
