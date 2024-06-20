package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.MapObjectCollectionListener as NativeMapObjectCollectionListener

actual class MapObjectCollectionListener actual constructor(
    val onMapObjectAdded: (mapObject: MapObject) -> Unit,
    val onMapObjectRemoved: (mapObject: MapObject) -> Unit,
) : NativeMapObjectCollectionListener {
    override fun onMapObjectAdded(p0: com.yandex.mapkit.map.MapObject) {
        onMapObjectAdded(p0.toCommon())
    }

    override fun onMapObjectRemoved(p0: com.yandex.mapkit.map.MapObject) {
        onMapObjectRemoved(p0.toCommon())
    }
}