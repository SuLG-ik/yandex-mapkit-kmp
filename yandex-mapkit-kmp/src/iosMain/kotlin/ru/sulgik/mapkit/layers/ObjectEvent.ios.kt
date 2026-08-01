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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ObjectEvent) return false
        if (this::class != other::class) return false
        return nativeObjectEvent == other.nativeObjectEvent
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeObjectEvent.hashCode()
    }
}

public fun NativeObjectEvent.toCommon(): ObjectEvent {
    return when (this) {
        is NativeUserLocationAnchorChanged -> toCommon()
        is NativeUserLocationIconChanged -> toCommon()
        else -> ObjectEvent(this)
    }
}
