package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect abstract class InputListener() {
    abstract fun onMapTap(map: Map, point: Point)
    abstract fun onMapLongTap(map: Map, point: Point)
}

inline fun InputListener(
    crossinline onMapTap: (map: Map, point: Point) -> Unit,
    crossinline onMapLongTap: (map: Map, point: Point) -> Unit,
): InputListener {
    return object : InputListener() {
        override fun onMapTap(map: Map, point: Point) {
            onMapTap.invoke(map, point)
        }

        override fun onMapLongTap(map: Map, point: Point) {
            onMapLongTap.invoke(map, point)
        }

    }
}