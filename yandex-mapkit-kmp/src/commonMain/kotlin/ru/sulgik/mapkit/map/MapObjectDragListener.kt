package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect abstract class MapObjectDragListener() {
    abstract fun onMapObjectDragStart(mapObject: MapObject)
    abstract fun onMapObjectDrag(mapObject: MapObject, point: Point)
    abstract fun onMapObjectDragEnd(mapObject: MapObject)
}

inline fun MapObjectDragListener(
    crossinline onMapObjectDragStart: (mapObject: MapObject) -> Unit,
    crossinline onMapObjectDrag: (mapObject: MapObject, point: Point) -> Unit,
    crossinline onMapObjectDragEnd: (mapObject: MapObject) -> Unit,
): MapObjectDragListener {
    return object : MapObjectDragListener() {
        override fun onMapObjectDragStart(mapObject: MapObject) {
            onMapObjectDragStart.invoke(mapObject)
        }

        override fun onMapObjectDrag(mapObject: MapObject, point: Point) {
            onMapObjectDrag.invoke(mapObject, point)
        }

        override fun onMapObjectDragEnd(mapObject: MapObject) {
            onMapObjectDragEnd.invoke(mapObject)
        }

    }
}