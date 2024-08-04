package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import YandexMapKit.YMKMapObject as NativeMapObject
import YandexMapKit.YMKMapObjectCollectionListenerProtocol as NativeMapObjectCollectionListener

public actual abstract class MapObjectCollectionListener actual constructor() {

    private val nativeListener = object : NativeMapObjectCollectionListener, NSObject() {

        override fun onMapObjectRemovedWithMapObject(mapObject: NativeMapObject) {
            onMapObjectRemoved(mapObject.toCommon())
        }

        override fun onMapObjectAddedWithMapObject(mapObject: NativeMapObject) {
            onMapObjectAdded(mapObject.toCommon())
        }
    }

    public fun toNative(): NativeMapObjectCollectionListener {
        return nativeListener
    }

    public actual abstract fun onMapObjectAdded(mapObject: MapObject)
    public actual abstract fun onMapObjectRemoved(mapObject: MapObject)
}