package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapObject
import YandexMapKit.YMKPoint
import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKMapObjectTapListenerProtocol as NativeMapObjectTapListener

actual class MapObjectTapListener actual constructor(
    private val onMapObjectTap: (mapObject: MapObject, point: Point) -> Boolean,
) : NativeMapObjectTapListener,
    NSObject() {

    override fun onMapObjectTapWithMapObject(mapObject: YMKMapObject, point: YMKPoint): Boolean {
        return onMapObjectTap(mapObject.toCommon(), point.toCommon())
    }
}