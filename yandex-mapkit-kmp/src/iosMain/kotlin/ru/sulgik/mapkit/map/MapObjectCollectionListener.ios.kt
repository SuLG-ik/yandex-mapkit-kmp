package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import YandexMapKit.YMKMapObject as NativeMapObject
import YandexMapKit.YMKMapObjectCollectionListenerProtocol as NativeMapObjectCollectionListener

public actual abstract class MapObjectCollectionListener actual constructor() : NativeConvertible<NativeMapObjectCollectionListener> {

    private val nativeListener = object : NativeMapObjectCollectionListener, NSObject() {

        override fun onMapObjectRemovedWithMapObject(mapObject: NativeMapObject) {
            onMapObjectRemoved(mapObject.toCommon())
        }

        override fun onMapObjectAddedWithMapObject(mapObject: NativeMapObject) {
            onMapObjectAdded(mapObject.toCommon())
        }
    }

    override fun toNative(): NativeMapObjectCollectionListener {
        return nativeListener
    }

    public actual abstract fun onMapObjectAdded(mapObject: MapObject)
    public actual abstract fun onMapObjectRemoved(mapObject: MapObject)
}