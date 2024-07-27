package ru.sulgik.mapkit.map

import YandexMapKit.YMKBaseMapObjectCollection as NativeBaseMapObjectCollection
import YandexMapKit.YMKClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection1
import YandexMapKit.YMKMapObjectCollection as NativeMapObjectCollection

actual open class BaseMapObjectCollection internal constructor(private val nativeBaseMapObjectCollection: NativeBaseMapObjectCollection) :
    MapObject(nativeBaseMapObjectCollection) {

    override fun toNative(): NativeBaseMapObjectCollection {
        return nativeBaseMapObjectCollection
    }

    actual fun traverse(mapObjectVisitor: MapObjectVisitor) {
        nativeBaseMapObjectCollection.traverseWithMapObjectVisitor(mapObjectVisitor)
    }

    actual fun remove(mapObject: MapObject) {
        nativeBaseMapObjectCollection.removeWithMapObject(mapObject.toNative())
    }

    actual fun clear() {
        nativeBaseMapObjectCollection.clear()
    }

    actual fun addListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.addListenerWithCollectionListener(collectionListener.toNative())
    }

    actual fun removeListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.removeListenerWithCollectionListener(collectionListener.toNative())
    }

}


fun NativeBaseMapObjectCollection.toCommon(): BaseMapObjectCollection {
    return when (this) {
        is NativeMapObjectCollection -> toCommon()
        is NativeClusterizedPlacemarkCollection1 -> toCommon()
        else -> BaseMapObjectCollection(this)
    }
}