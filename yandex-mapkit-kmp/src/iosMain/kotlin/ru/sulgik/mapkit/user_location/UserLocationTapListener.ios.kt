package ru.sulgik.mapkit.user_location

import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKPoint as NativePoint
import YandexMapKit.YMKUserLocationTapListenerProtocol as NativeUserLocationTapListener

public actual abstract class UserLocationTapListener actual constructor() {

    private val nativeListener = object : NativeUserLocationTapListener, NSObject() {
        override fun onUserLocationObjectTapWithPoint(point: NativePoint) {
            onUserLocationObjectTap(point.toCommon())
        }
    }

    public fun toNative(): NativeUserLocationTapListener {
        return nativeListener
    }

    public actual abstract fun onUserLocationObjectTap(point: Point)

}