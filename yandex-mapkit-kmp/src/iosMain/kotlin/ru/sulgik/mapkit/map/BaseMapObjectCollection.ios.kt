package ru.sulgik.mapkit.map

import YandexMapKit.YMKBaseMapObjectCollection as NativeBaseMapObjectCollection

actual open class BaseMapObjectCollection(private val nativeBaseMapObjectCollection: NativeBaseMapObjectCollection) :
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
        nativeBaseMapObjectCollection.addListenerWithCollectionListener(collectionListener)
    }

    actual fun removeListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.removeListenerWithCollectionListener(collectionListener)
    }

}