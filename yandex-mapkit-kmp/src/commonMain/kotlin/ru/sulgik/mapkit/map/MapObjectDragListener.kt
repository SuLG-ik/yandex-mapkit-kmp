package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect abstract class MapObjectDragListener {

    abstract fun onMapObjectDragStart(mapObject: MapObject)

    abstract fun onMapObjectDrag(mapObject: MapObject, point: Point)

    abstract fun onMapObjectDragEnd(mapObject: MapObject)

}