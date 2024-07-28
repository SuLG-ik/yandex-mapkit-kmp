package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.user_location.toCommon
import com.yandex.mapkit.layers.ObjectEvent as NativeObjectEvent
import com.yandex.mapkit.user_location.UserLocationAnchorChanged as NativeUserLocationAnchorChanged
import com.yandex.mapkit.user_location.UserLocationIconChanged as NativeUserLocationIconChanged

actual open class ObjectEvent(private val nativeObjectEvent: NativeObjectEvent) {

    open fun toNative(): NativeObjectEvent {
        return nativeObjectEvent
    }

}

fun NativeObjectEvent.toCommon(): ObjectEvent {
    return when (this) {
        is NativeUserLocationAnchorChanged -> toCommon()
        is NativeUserLocationIconChanged -> toCommon()
        else -> ObjectEvent(this)
    }
}

