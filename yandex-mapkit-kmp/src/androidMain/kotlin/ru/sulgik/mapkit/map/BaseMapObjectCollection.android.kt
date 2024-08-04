package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.BaseMapObjectCollection as NativeBaseMapObjectCollection
import com.yandex.mapkit.map.ClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection1
import com.yandex.mapkit.map.MapObjectCollection as NativeMapObjectCollection

public actual open class BaseMapObjectCollection internal constructor(
    private val nativeBaseMapObjectCollection: NativeBaseMapObjectCollection,
) : MapObject(nativeBaseMapObjectCollection) {

    override fun toNative(): NativeBaseMapObjectCollection {
        return nativeBaseMapObjectCollection
    }

    public actual fun traverse(mapObjectVisitor: MapObjectVisitor) {
        nativeBaseMapObjectCollection.traverse(mapObjectVisitor)
    }

    public actual fun remove(mapObject: MapObject) {
        nativeBaseMapObjectCollection.remove(mapObject.toNative())
    }

    public actual fun clear() {
        nativeBaseMapObjectCollection.clear()
    }

    public actual fun addListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.addListener(collectionListener.toNative())
    }

    public actual fun removeListener(collectionListener: MapObjectCollectionListener) {
        nativeBaseMapObjectCollection.removeListener(collectionListener.toNative())
    }

}

public fun NativeBaseMapObjectCollection.toCommon(): BaseMapObjectCollection {
    return when (this) {
        is NativeMapObjectCollection -> toCommon()
        is NativeClusterizedPlacemarkCollection1 -> toCommon()
        else -> BaseMapObjectCollection(this)
    }
}