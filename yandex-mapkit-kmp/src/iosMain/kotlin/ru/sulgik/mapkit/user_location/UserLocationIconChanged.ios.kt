package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent
import YandexMapKit.YMKUserLocationIconChanged as NativeUserLocationIconChanged

public actual class UserLocationIconChanged internal constructor(
    private val nativeUserLocationIconChanged: NativeUserLocationIconChanged,
) : ObjectEvent(nativeUserLocationIconChanged) {

    override fun toNative(): NativeUserLocationIconChanged {
        return nativeUserLocationIconChanged
    }

    public actual val iconType: UserLocationIconType
        get() = nativeUserLocationIconChanged.iconType.toCommon()

}

public fun NativeUserLocationIconChanged.toCommon(): UserLocationIconChanged {
    return UserLocationIconChanged(this)
}