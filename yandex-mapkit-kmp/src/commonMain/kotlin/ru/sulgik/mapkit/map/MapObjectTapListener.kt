package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect abstract class MapObjectTapListener() {
    abstract fun onMapObjectTap(mapObject: MapObject, point: Point): Boolean
}

inline fun MapObjectTapListener(
    crossinline onMapObjectTap: (mapObject: MapObject, point: Point) -> Boolean
): MapObjectTapListener {
    return object : MapObjectTapListener() {
        override fun onMapObjectTap(mapObject: MapObject, point: Point): Boolean {
            return onMapObjectTap.invoke(mapObject, point)
        }
    }
}