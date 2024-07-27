package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point

expect class InputListener(
    onMapTap: (
        map: Map,
        point: Point,
    ) -> Unit,
    onMapLongTap: (
        map: Map,
        point: Point,
    ) -> Unit,
)