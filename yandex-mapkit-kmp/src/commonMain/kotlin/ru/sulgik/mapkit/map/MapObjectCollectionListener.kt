package ru.sulgik.mapkit.map

expect abstract class MapObjectCollectionListener {

    abstract fun onMapObjectAdded(mapObject: MapObject)

    abstract fun onMapObjectRemoved(mapObject: MapObject)

}