package ru.sulgik.mapkit.map

public expect abstract class MapObjectCollectionListener() {
    public abstract fun onMapObjectAdded(mapObject: MapObject)
    public abstract fun onMapObjectRemoved(mapObject: MapObject)
}

public inline fun MapObjectCollectionListener(
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