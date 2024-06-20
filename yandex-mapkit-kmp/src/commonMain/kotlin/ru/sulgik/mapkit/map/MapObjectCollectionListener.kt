package ru.sulgik.mapkit.map

expect class MapObjectCollectionListener(
    onMapObjectAdded: (mapObject: MapObject) -> Unit,
    onMapObjectRemoved: (mapObject: MapObject) -> Unit,
)