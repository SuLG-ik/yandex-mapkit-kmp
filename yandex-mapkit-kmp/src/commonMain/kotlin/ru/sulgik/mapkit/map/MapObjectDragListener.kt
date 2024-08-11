package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

public expect abstract class MapObjectDragListener() {
    public abstract fun onMapObjectDragStart(mapObject: MapObject)
    public abstract fun onMapObjectDrag(mapObject: MapObject, point: Point)
    public abstract fun onMapObjectDragEnd(mapObject: MapObject)
}

public inline fun MapObjectDragListener(
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