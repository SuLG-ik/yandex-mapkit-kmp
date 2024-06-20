package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapObject
import platform.darwin.NSObject
import YandexMapKit.YMKMapObjectCollectionListenerProtocol as NativeMapObjectCollectionListener

actual class MapObjectCollectionListener actual constructor(
    val onMapObjectAdded: (mapObject: MapObject) -> Unit,
    val onMapObjectRemoved: (mapObject: MapObject) -> Unit,
) : NativeMapObjectCollectionListener,
    NSObject() {

    override fun onMapObjectRemovedWithMapObject(mapObject: YMKMapObject) {
        onMapObjectRemoved(mapObject.toCommon())
    }

    override fun onMapObjectAddedWithMapObject(mapObject: YMKMapObject) {
        onMapObjectAdded(mapObject.toCommon())
    }
}