package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.BaseMapObjectCollection as NativeBaseMapObjectCollection

actual open class BaseMapObjectCollection internal constructor(
    private val nativeBaseMapObjectCollection: NativeBaseMapObjectCollection,
) :
    MapObject(nativeBaseMapObjectCollection) {

    override fun toNative(): NativeBaseMapObjectCollection {
        return nativeBaseMapObjectCollection
    }

    actual fun traverse(mapObjectVisitor: MapObjectVisitor) {
        nativeBaseMapObjectCollection.traverse(mapObjectVisitor)
    }

    actual fun remove(mapObject: MapObject) {
        nativeBaseMapObjectCollection.remove(mapObject.toNative())
    }

    actual fun clear() {
        nativeBaseMapObjectCollection.clear()
    }

    actual fun addListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.addListener(collectionListener)
    }

    actual fun removeListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.removeListener(collectionListener)
    }

}