package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

public expect abstract class InputListener() {
    public abstract fun onMapTap(map: Map, point: Point)
    public abstract fun onMapLongTap(map: Map, point: Point)
}

public inline fun InputListener(
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