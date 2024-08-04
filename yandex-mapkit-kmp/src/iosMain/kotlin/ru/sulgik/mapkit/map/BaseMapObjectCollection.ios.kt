package ru.sulgik.mapkit.map

import YandexMapKit.YMKBaseMapObjectCollection as NativeBaseMapObjectCollection
import YandexMapKit.YMKClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection
import YandexMapKit.YMKMapObjectCollection as NativeMapObjectCollection

public actual open class BaseMapObjectCollection internal constructor(private val nativeBaseMapObjectCollection: NativeBaseMapObjectCollection) :
    MapObject(nativeBaseMapObjectCollection) {

    override fun toNative(): NativeBaseMapObjectCollection {
        return nativeBaseMapObjectCollection
    }

    public actual fun traverse(mapObjectVisitor: MapObjectVisitor) {
        nativeBaseMapObjectCollection.traverseWithMapObjectVisitor(mapObjectVisitor)
    }

    public actual fun remove(mapObject: MapObject) {
        nativeBaseMapObjectCollection.removeWithMapObject(mapObject.toNative())
    }

    public actual fun clear() {
        nativeBaseMapObjectCollection.clear()
    }

    public actual fun addListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.addListenerWithCollectionListener(collectionListener.toNative())
    }

    public actual fun removeListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.removeListenerWithCollectionListener(collectionListener.toNative())
    }

}


public fun NativeBaseMapObjectCollection.toCommon(): BaseMapObjectCollection {
    return when (this) {
        is NativeMapObjectCollection -> toCommon()
        is NativeClusterizedPlacemarkCollection -> toCommon()
        else -> BaseMapObjectCollection(this)
    }
}