package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect class MapObjectTapListener(onMapObjectTap: (mapObject: MapObject, point: Point) -> Boolean)