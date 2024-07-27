package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.BaseMapObjectCollection as NativeBaseMapObjectCollection
import com.yandex.mapkit.map.ClusterizedPlacemarkCollection as NativeClusterizedPlacemarkCollection1
import com.yandex.mapkit.map.MapObjectCollection as NativeMapObjectCollection

actual open class BaseMapObjectCollection internal constructor(
    private val nativeBaseMapObjectCollection: NativeBaseMapObjectCollection,
) : MapObject(nativeBaseMapObjectCollection) {

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

fun NativeBaseMapObjectCollection.toCommon(): BaseMapObjectCollection {
    return when (this) {
        is NativeMapObjectCollection -> toCommon()
        is NativeClusterizedPlacemarkCollection1 -> toCommon()
        else -> BaseMapObjectCollection(this)
    }
}