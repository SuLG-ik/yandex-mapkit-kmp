package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKMap as NativeMap
import YandexMapKit.YMKMapInputListenerProtocol as NativeInputListener
import YandexMapKit.YMKPoint as NativePoint

actual class InputListener actual constructor(
    private val onMapTap: (map: Map, point: Point) -> Unit,
    private val onMapLongTap: (map: Map, point: Point) -> Unit,
) : NativeInputListener, NSObject() {
    override fun onMapLongTapWithMap(map: NativeMap, point: NativePoint) {
        onMapTap.invoke(map.toCommon(), point.toCommon())
    }

    override fun onMapTapWithMap(map: NativeMap, point: NativePoint) {
        onMapLongTap.invoke(map.toCommon(), point.toCommon())
    }
}