package ru.sulgik.mapkit.sample

import ru.sulgik.mapkit.geometry.LinearRing
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polygon
import ru.sulgik.mapkit.map.CameraPosition

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