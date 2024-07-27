package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.geometry.Point

expect abstract class UserLocationTapListener() {
    abstract fun onUserLocationObjectTap(point: Point)
}

inline fun UserLocationTapListener(
    crossinline onUserLocationObjectTap: (point: Point) -> Unit,
): UserLocationTapListener {
    return object : UserLocationTapListener() {
        override fun onUserLocationObjectTap(point: Point) {
            onUserLocationObjectTap.invoke(point)
        }
    }
}