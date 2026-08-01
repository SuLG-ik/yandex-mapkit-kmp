package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.GeoObject
import ru.sulgik.mapkit.toCommon
import YandexMapKit.YMKGeoObjectTapEvent as NativeGeoObjectTapEvent

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
        get() = nativeGeoObjectTapEvent.isValid()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GeoObjectTapEvent) return false
        if (this::class != other::class) return false
        return nativeGeoObjectTapEvent == other.nativeGeoObjectTapEvent
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeGeoObjectTapEvent.hashCode()
    }
}

public fun NativeGeoObjectTapEvent.toCommon(): GeoObjectTapEvent {
    return GeoObjectTapEvent(this)
}
