package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import YandexMapKit.YMKMapObject as NativeMapObject
import YandexMapKit.YMKMapObjectCollectionListenerProtocol as NativeMapObjectCollectionListener

actual abstract class MapObjectCollectionListener actual constructor() {

    private val nativeListener = object : NativeMapObjectCollectionListener, NSObject() {

        override fun onMapObjectRemovedWithMapObject(mapObject: NativeMapObject) {
            onMapObjectRemoved(mapObject.toCommon())
        }

        override fun onMapObjectAddedWithMapObject(mapObject: NativeMapObject) {
            onMapObjectAdded(mapObject.toCommon())
        }
    }

    fun toNative(): NativeMapObjectCollectionListener {
        return nativeListener
    }

    actual abstract fun onMapObjectAdded(mapObject: MapObject)
    actual abstract fun onMapObjectRemoved(mapObject: MapObject)
}