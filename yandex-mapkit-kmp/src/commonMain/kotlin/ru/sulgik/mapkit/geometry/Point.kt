package ru.sulgik.mapkit.geometry

public data class Point(val latitude: Latitude, val longitude: Longitude)

public fun Point(latitude: Double, longitude: Double): Point {
    return Point(Latitude(latitude), Longitude(longitude))
}

internal fun List<Point>.pointsListToString(): String {
    return "[${joinToString(", ")}]"
}