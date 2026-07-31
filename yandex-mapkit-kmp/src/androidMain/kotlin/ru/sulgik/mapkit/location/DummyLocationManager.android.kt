package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.DummyLocationManager as NativeDummyLocationManager

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
}

public fun NativeDummyLocationManager.toCommon(): DummyLocationManager {
    return DummyLocationManager(this)
}
