package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.GeoObject
import ru.sulgik.mapkit.toCommon
import com.yandex.mapkit.layers.GeoObjectTapEvent as NativeGeoObjectTapEvent

/**
 * A tap on an object of the base map.
 */
public actual class GeoObjectTapEvent internal constructor(
    private val nativeGeoObjectTapEvent: NativeGeoObjectTapEvent,
) {

    public fun toNative(): NativeGeoObjectTapEvent {
        return nativeGeoObjectTapEvent
    }

    /**
     * The object that was tapped.
     */
    public actual val geoObject: GeoObject
        get() = nativeGeoObjectTapEvent.geoObject.toCommon()

    /**
     * Tells if this **GeoObjectTapEvent** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeGeoObjectTapEvent.isValid
}

public fun NativeGeoObjectTapEvent.toCommon(): GeoObjectTapEvent {
    return GeoObjectTapEvent(this)
}
