package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent
import YandexMapKit.YMKUserLocationIconChanged as NativeUserLocationIconChanged

actual class UserLocationIconChanged internal constructor(
    private val nativeUserLocationIconChanged: NativeUserLocationIconChanged,
) : ObjectEvent(nativeUserLocationIconChanged) {

    override fun toNative(): NativeUserLocationIconChanged {
        return nativeUserLocationIconChanged
    }

    actual val iconType: UserLocationIconType
        get() = nativeUserLocationIconChanged.iconType.toCommon()

}

fun NativeUserLocationIconChanged.toCommon(): UserLocationIconChanged {
    return UserLocationIconChanged(this)
}