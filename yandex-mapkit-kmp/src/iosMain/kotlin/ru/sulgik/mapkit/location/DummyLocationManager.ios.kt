package ru.sulgik.mapkit.location

import YandexMapKit.YMKDummyLocationManager as NativeDummyLocationManager

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
        nativeDummyLocationManager.setLocationWithLocation(location.toNative(), quality.toNative())
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
