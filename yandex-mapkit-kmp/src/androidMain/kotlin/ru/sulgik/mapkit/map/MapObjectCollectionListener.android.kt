package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapObject as NativeMapObject
import com.yandex.mapkit.map.MapObjectCollectionListener as NativeMapObjectCollectionListener

actual abstract class MapObjectCollectionListener actual constructor() {
    private val nativeListener = object : NativeMapObjectCollectionListener {
        override fun onMapObjectAdded(p0: NativeMapObject) {
            onMapObjectAdded(p0.toCommon())
        }

        override fun onMapObjectRemoved(p0: NativeMapObject) {
            onMapObjectRemoved(p0.toCommon())
        }
    }

    fun toNative(): NativeMapObjectCollectionListener {
        return nativeListener
    }

    actual abstract fun onMapObjectAdded(mapObject: MapObject)
    actual abstract fun onMapObjectRemoved(mapObject: MapObject)
}