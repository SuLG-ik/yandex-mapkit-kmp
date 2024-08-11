package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapObject as NativeMapObject
import com.yandex.mapkit.map.MapObjectCollectionListener as NativeMapObjectCollectionListener

public actual abstract class MapObjectCollectionListener actual constructor() {
    private val nativeListener = object : NativeMapObjectCollectionListener {
        override fun onMapObjectAdded(p0: NativeMapObject) {
            onMapObjectAdded(p0.toCommon())
        }

        override fun onMapObjectRemoved(p0: NativeMapObject) {
            onMapObjectRemoved(p0.toCommon())
        }
    }

    public fun toNative(): NativeMapObjectCollectionListener {
        return nativeListener
    }

    public actual abstract fun onMapObjectAdded(mapObject: MapObject)
    public actual abstract fun onMapObjectRemoved(mapObject: MapObject)
}