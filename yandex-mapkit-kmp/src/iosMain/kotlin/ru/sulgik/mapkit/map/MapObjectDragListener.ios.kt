package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapObject
import YandexMapKit.YMKMapObjectDragListenerProtocol
import YandexMapKit.YMKPoint
import platform.darwin.NSObject
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon

actual class MapObjectDragListener actual constructor(
    private val onMapObjectDragStart: (mapObject: MapObject) -> Unit,
    private val onMapObjectDrag: (mapObject: MapObject, point: Point) -> Unit,
    private val onMapObjectDragEnd: (mapObject: MapObject) -> Unit,
) : YMKMapObjectDragListenerProtocol, NSObject() {

    override fun onMapObjectDragEndWithMapObject(mapObject: YMKMapObject) {
        onMapObjectDragEnd(mapObject.toCommon())
    }

    override fun onMapObjectDragStartWithMapObject(mapObject: YMKMapObject) {
        onMapObjectDragStart(mapObject.toCommon())
    }

    override fun onMapObjectDragWithMapObject(mapObject: YMKMapObject, point: YMKPoint) {
        onMapObjectDrag(mapObject.toCommon(), point.toCommon())
    }
}