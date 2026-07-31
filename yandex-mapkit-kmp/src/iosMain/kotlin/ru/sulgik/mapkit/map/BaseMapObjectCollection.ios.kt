package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.WeakRef
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKBaseMapObjectCollection as NativeBaseMapObjectCollection
import YandexMapKit.YMKClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection
import YandexMapKit.YMKMapObjectCollection as NativeMapObjectCollection

public actual open class BaseMapObjectCollection internal constructor(private val nativeBaseMapObjectCollection: NativeBaseMapObjectCollection) :
    MapObject(nativeBaseMapObjectCollection) {

    override fun toNative(): NativeBaseMapObjectCollection {
        return nativeBaseMapObjectCollection
    }

    public actual fun traverse(mapObjectVisitor: WeakRef<MapObjectVisitor>) {
        nativeBaseMapObjectCollection.traverseWithMapObjectVisitor(mapObjectVisitor.toNative() ?: return)
    }

    public actual fun remove(mapObject: MapObject) {
        nativeBaseMapObjectCollection.removeWithMapObject(mapObject.toNative())
    }

    public actual fun clear() {
        nativeBaseMapObjectCollection.clear()
    }

    public actual fun addListener(collectionListener: WeakRef<MapObjectCollectionListener>) {
        nativeBaseMapObjectCollection.addListenerWithCollectionListener(collectionListener.toNative() ?: return)
    }

    public actual fun removeListener(collectionListener: WeakRef<MapObjectCollectionListener>) {
        nativeBaseMapObjectCollection.removeListenerWithCollectionListener(collectionListener.toNative() ?: return)
    }

}

public fun NativeBaseMapObjectCollection.toCommon(): BaseMapObjectCollection {
    return when (this) {
        is NativeMapObjectCollection -> toCommon()
        is NativeClusterizedPlacemarkCollection -> toCommon()
        else -> BaseMapObjectCollection(this)
    }
}