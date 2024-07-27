package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.map.CircleMapObject
import ru.sulgik.mapkit.map.PlacemarkMapObject
import ru.sulgik.mapkit.map.toCommon
import YandexMapKit.YMKUserLocationView as NativeUserLocationView

actual class UserLocationView internal constructor(
    private val nativeUserLocationView: NativeUserLocationView,
) {
    fun toNative(): NativeUserLocationView {
        return nativeUserLocationView
    }

    actual val arrow: PlacemarkMapObject
        get() = nativeUserLocationView.arrow.toCommon()
    actual val pin: PlacemarkMapObject
        get() = nativeUserLocationView.pin.toCommon()
    actual val accuracyCircle: CircleMapObject
        get() = nativeUserLocationView.accuracyCircle.toCommon()
}

fun NativeUserLocationView.toCommon(): UserLocationView {
    return UserLocationView(this)
}