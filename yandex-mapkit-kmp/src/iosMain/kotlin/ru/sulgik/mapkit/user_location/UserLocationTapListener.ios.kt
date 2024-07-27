package ru.sulgik.mapkit.user_location

import YandexMapKit.YMKUserLocationTapListenerProtocol
import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKPoint as NativePoint

actual class UserLocationTapListener actual constructor(
    private val onUserLocationObjectTap: (point: Point) -> Unit,
) : YMKUserLocationTapListenerProtocol, NSObject() {
    override fun onUserLocationObjectTapWithPoint(point: NativePoint) {
        onUserLocationObjectTap.invoke(point.toCommon())
    }

}