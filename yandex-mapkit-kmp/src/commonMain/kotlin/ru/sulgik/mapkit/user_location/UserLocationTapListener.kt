package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.geometry.Point

expect class UserLocationTapListener(
    onUserLocationObjectTap: (point: Point) -> Unit,
)