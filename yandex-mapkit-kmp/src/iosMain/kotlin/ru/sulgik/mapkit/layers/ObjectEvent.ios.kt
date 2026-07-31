package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.user_location.toCommon
import YandexMapKit.YMKObjectEvent as NativeObjectEvent
import YandexMapKit.YMKUserLocationAnchorChanged as NativeUserLocationAnchorChanged
import YandexMapKit.YMKUserLocationIconChanged as NativeUserLocationIconChanged

public actual open class ObjectEvent internal constructor(private val nativeObjectEvent: NativeObjectEvent) {

    public open fun toNative(): NativeObjectEvent {
        return nativeObjectEvent
    }

    /**
     * Tells if this **ObjectEvent** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeObjectEvent.isValid()
}

public fun NativeObjectEvent.toCommon(): ObjectEvent {
    return when (this) {
        is NativeUserLocationAnchorChanged -> toCommon()
        is NativeUserLocationIconChanged -> toCommon()
        else -> ObjectEvent(this)
    }
}
