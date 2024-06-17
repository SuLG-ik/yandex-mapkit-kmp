package ru.sulgik.mapkit.geometry

data class Point(val latitude: Latitude, val longitude: Longitude)

fun Point(latitude: Double, longitude: Double): Point {
    return Point(Latitude(latitude), Longitude(longitude))
}