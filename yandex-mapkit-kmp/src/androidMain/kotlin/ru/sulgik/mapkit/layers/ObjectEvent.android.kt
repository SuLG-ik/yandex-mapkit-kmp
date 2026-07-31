package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.user_location.toCommon
import com.yandex.mapkit.layers.ObjectEvent as NativeObjectEvent
import com.yandex.mapkit.user_location.UserLocationAnchorChanged as NativeUserLocationAnchorChanged
import com.yandex.mapkit.user_location.UserLocationIconChanged as NativeUserLocationIconChanged

public actual open class ObjectEvent(private val nativeObjectEvent: NativeObjectEvent) {

    public open fun toNative(): NativeObjectEvent {
        return nativeObjectEvent
    }

    /**
     * Tells if this **ObjectEvent** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativeObjectEvent.isValid
}

public fun NativeObjectEvent.toCommon(): ObjectEvent {
    return when (this) {
        is NativeUserLocationAnchorChanged -> toCommon()
        is NativeUserLocationIconChanged -> toCommon()
        else -> ObjectEvent(this)
    }
}
