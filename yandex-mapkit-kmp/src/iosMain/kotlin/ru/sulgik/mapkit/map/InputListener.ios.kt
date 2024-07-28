package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKMap as NativeMap
import YandexMapKit.YMKMapInputListenerProtocol as NativeInputListener
import YandexMapKit.YMKPoint as NativePoint

actual abstract class InputListener actual constructor() {
    private val nativeListener = object : NativeInputListener, NSObject() {
        override fun onMapLongTapWithMap(map: NativeMap, point: NativePoint) {
            onMapTap(map.toCommon(), point.toCommon())
        }

        override fun onMapTapWithMap(map: NativeMap, point: NativePoint) {
            onMapLongTap(map.toCommon(), point.toCommon())
        }
    }

    fun toNative(): NativeInputListener {
        return nativeListener
    }

    actual abstract fun onMapTap(
        map: Map,
        point: Point,
    )

    actual abstract fun onMapLongTap(
        map: Map,
        point: Point,
    )
}