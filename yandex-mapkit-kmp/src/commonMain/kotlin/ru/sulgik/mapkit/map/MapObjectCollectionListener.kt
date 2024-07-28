package ru.sulgik.mapkit.map

expect abstract class MapObjectCollectionListener() {
    abstract fun onMapObjectAdded(mapObject: MapObject)
    abstract fun onMapObjectRemoved(mapObject: MapObject)
}

inline fun MapObjectCollectionListener(
    crossinline onMapObjectAdded: (mapObject: MapObject) -> Unit,
    crossinline onMapObjectRemoved: (mapObject: MapObject) -> Unit,
): MapObjectCollectionListener {
    return object : MapObjectCollectionListener() {
        override fun onMapObjectAdded(mapObject: MapObject) {
            onMapObjectAdded.invoke(mapObject)
        }

        override fun onMapObjectRemoved(mapObject: MapObject) {
            onMapObjectRemoved.invoke(mapObject)
        }
    }
}