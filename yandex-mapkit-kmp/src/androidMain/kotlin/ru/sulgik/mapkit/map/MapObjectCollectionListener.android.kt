package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapObjectCollectionListener as NativeMapObjectCollectionListener

actual abstract class MapObjectCollectionListener : NativeMapObjectCollectionListener {
    actual abstract fun onMapObjectAdded(mapObject: MapObject)
    actual abstract fun onMapObjectRemoved(mapObject: MapObject)

    override fun onMapObjectAdded(p0: com.yandex.mapkit.map.MapObject) {
        onMapObjectAdded(p0.toCommon())
    }

    override fun onMapObjectRemoved(p0: com.yandex.mapkit.map.MapObject) {
        onMapObjectRemoved(p0.toCommon())
    }
}