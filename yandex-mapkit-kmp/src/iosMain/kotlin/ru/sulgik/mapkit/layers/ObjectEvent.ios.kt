package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.user_location.toCommon
import YandexMapKit.YMKObjectEvent as NativeObjectEvent
import YandexMapKit.YMKUserLocationAnchorChanged as NativeUserLocationAnchorChanged
import YandexMapKit.YMKUserLocationIconChanged as NativeUserLocationIconChanged

actual open class ObjectEvent internal constructor(private val nativeObjectEvent: NativeObjectEvent) {

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

