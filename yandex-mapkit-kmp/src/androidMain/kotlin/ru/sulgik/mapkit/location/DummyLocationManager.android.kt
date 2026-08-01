package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.DummyLocationManager as NativeDummyLocationManager
import com.yandex.mapkit.location.LocationManager as NativeLocationManager

/**
 * A location manager whose positions are pushed in by the application.
 */
public actual class DummyLocationManager internal constructor(
    private val nativeDummyLocationManager: NativeDummyLocationManager,
) {

    public fun toNative(): NativeDummyLocationManager {
        return nativeDummyLocationManager
    }

    /**
     * Sets a location and notifies all consumers of this location.
     */
    public actual fun setLocation(location: Location, quality: DummyLocationQuality) {
        nativeDummyLocationManager.setLocation(location.toNative(), quality.toNative())
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DummyLocationManager) return false
        if (this::class != other::class) return false
        return nativeDummyLocationManager == other.nativeDummyLocationManager
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeDummyLocationManager.hashCode()
    }
}

public fun NativeDummyLocationManager.toCommon(): DummyLocationManager {
    return DummyLocationManager(this)
}

/**
 * Views the dummy manager as the [LocationManager] that MapKit derives it from.
 *
 * The returned manager drives the same underlying object, so
 * [LocationManager.subscribeForLocationUpdates] and [LocationManager.requestSingleUpdate] deliver
 * the locations pushed in with [DummyLocationManager.setLocation], and [LocationManager.suspend]
 * and [LocationManager.resume] control whether they reach the subscribers. The result can also be
 * handed to [ru.sulgik.mapkit.MapKit.setLocationManager] and [toLocationViewSource].
 */
public actual fun DummyLocationManager.asLocationManager(): LocationManager {
    val nativeLocationManager: NativeLocationManager = toNative()
    return nativeLocationManager.toCommon()
}
