package ru.sulgik.mapkit.sample

import ru.sulgik.mapkit.geometry.Circle
import ru.sulgik.mapkit.geometry.LinearRing
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.map.CameraPosition

fun randomPlacemarks(): List<Pair<Point, MapObjectUserData>> {
    return clusterizedPoints.mapIndexed { index, point ->
        point to MapObjectUserData(
            type = MapObjectType.entries.random(),
            name = "point_$index"
        )
    }
}

fun randomCircles(): List<Pair<Circle, MapObjectUserData>> {
    return listOf(
        Circle(
            Point(59.939866, 30.314352),
            (200..600).random().toFloat()
        ) to MapObjectUserData(
            type = MapObjectType.entries.random(),
            name = "circle_0"
        )
    )
}

val startPosition = CameraPosition(Point(59.935016, 30.328903), 15f, 0f, 0f)

val polygon: Polygon
    get() {
        var points = listOf(
            59.935535 to 30.326926,
            59.938961 to 30.328576,
            59.938152 to 30.336384,
            59.934600 to 30.335049,
        ).map { (lat, lon) -> Point(lat, lon) }

        points = points + points.first()
        val ring = LinearRing(points)

        val innerRing = listOf(
            59.936698 to 30.331271,
            59.937495 to 30.329910,
            59.937854 to 30.331909,
            59.937112 to 30.333312,
            59.936698 to 30.331271,
        )
            .map { (lat, lon) -> Point(lat, lon) }
            .let { LinearRing(it) }

        return Polygon(
            ring,
            listOf(innerRing)
        )
    }

val polyline: Polyline
    get() {
        val points = listOf(
            59.933475 to 30.325256,
            59.933947 to 30.323115,
            59.935667 to 30.324070,
            59.935901 to 30.322370,
            59.941026 to 30.324789,
        ).map { (lat, lon) -> Point(lat, lon) }
        return Polyline(points)
    }

val clusterizedPoints = listOf(
    59.935535 to 30.326926,
    59.938961 to 30.328576,
    59.938152 to 30.336384,
    59.934600 to 30.335049,
    59.938386 to 30.329092,
    59.938495 to 30.330557,
    59.938854 to 30.332325,
    59.937930 to 30.333767,
    59.937766 to 30.335208,
    59.938203 to 30.334316,
    59.938607 to 30.337340,
    59.937988 to 30.337596,
    59.938168 to 30.338533,
    59.938780 to 30.339794,
    59.939095 to 30.338655,
    59.939815 to 30.337967,
    59.939365 to 30.340293,
    59.935220 to 30.333730,
    59.935792 to 30.335223,
    59.935814 to 30.332945,
).map { (lat, lon) -> Point(lat, lon) }