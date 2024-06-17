package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect abstract class MapObjectTapListener() {

    abstract fun onMapObjectTap(mapObject: MapObject, point: Point): Boolean

}

private class LambdaMapObjectTapListener(val onMapObjectTap: (mapObject: MapObject, point: Point) -> Boolean) :
    MapObjectTapListener() {
    override fun onMapObjectTap(mapObject: MapObject, point: Point): Boolean {
        return onMapObjectTap.invoke(mapObject, point)
    }


}

fun MapObjectTapListener(onMapObjectTap: (mapObject: MapObject, point: Point) -> Boolean): MapObjectTapListener {
    return LambdaMapObjectTapListener(onMapObjectTap)
}