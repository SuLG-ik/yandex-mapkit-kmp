package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKMapObject as NativeMapObject
import YandexMapKit.YMKMapObjectDragListenerProtocol as NativeMapObjectDragListener
import YandexMapKit.YMKPoint as NativePoint

public actual abstract class MapObjectDragListener actual constructor() {
    private val nativeListener = object : NativeMapObjectDragListener, NSObject() {
        override fun onMapObjectDragEndWithMapObject(mapObject: NativeMapObject) {
            onMapObjectDragEnd(mapObject.toCommon())
        }

        override fun onMapObjectDragStartWithMapObject(mapObject: NativeMapObject) {
            onMapObjectDragStart(mapObject.toCommon())
        }

        override fun onMapObjectDragWithMapObject(mapObject: NativeMapObject, point: NativePoint) {
            onMapObjectDrag(mapObject.toCommon(), point.toCommon())
        }
    }

    public fun toNative(): NativeMapObjectDragListener {
        return nativeListener
    }

    public actual abstract fun onMapObjectDragStart(mapObject: MapObject)
    public actual abstract fun onMapObjectDrag(mapObject: MapObject, point: Point)
    public actual abstract fun onMapObjectDragEnd(mapObject: MapObject)
}