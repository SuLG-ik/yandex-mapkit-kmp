package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect class MapObjectDragListener(
    onMapObjectDragStart: (mapObject: MapObject) -> Unit,
    onMapObjectDrag: (mapObject: MapObject, point: Point) -> Unit,
    onMapObjectDragEnd: (mapObject: MapObject) -> Unit,
)