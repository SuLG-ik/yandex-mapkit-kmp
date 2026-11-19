package ru.sulgik.liteconsumer

import ru.sulgik.mapkit.geometry.Geo
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.geo.pointByPolylinePosition

private const val waypointSnapToleranceMeters = 250.0

internal fun drivingWaypointsMatch(
    geometry: Polyline,
    wayPoints: List<PolylinePosition>,
    requestedPoints: List<Point>,
    reportedRequestPoints: List<Point>?,
): Boolean {
    val segmentCount = geometry.points.size - 1
    if (segmentCount < 1 || requestedPoints.size < 2 || wayPoints.size < requestedPoints.size) return false
    if (wayPoints.any { it.segmentIndex !in 0 until segmentCount || it.segmentPosition !in 0.0..1.0 }) return false
    val ordered = wayPoints.zipWithNext().all { (first, next) ->
        first.segmentIndex + first.segmentPosition < next.segmentIndex + next.segmentPosition
    }
    if (!ordered) return false
    if (reportedRequestPoints != null) return reportedRequestPoints == requestedPoints

    val origin = geometry.pointByPolylinePosition(wayPoints.first())
    val destination = geometry.pointByPolylinePosition(wayPoints.last())
    return Geo.distance(origin, requestedPoints.first()) <= waypointSnapToleranceMeters &&
        Geo.distance(destination, requestedPoints.last()) <= waypointSnapToleranceMeters
}

internal fun verifyDrivingWaypoints() {
    val origin = Point(55.756, 37.618)
    val destination = Point(55.728, 37.581)
    val retiredDestination = Point(55.764, 37.605)
    val geometry = Polyline(listOf(origin, Point(55.738, 37.590), Point(55.7281, 37.581)))
    val requested = listOf(origin, destination)
    val wayPoints = listOf(PolylinePosition(0, 0.0), PolylinePosition(1, 1.0))

    check(drivingWaypointsMatch(geometry, wayPoints, requested, null))
    check(drivingWaypointsMatch(geometry, wayPoints, requested, requested))
    check(!drivingWaypointsMatch(geometry, wayPoints, listOf(origin, retiredDestination), null))
    check(!drivingWaypointsMatch(geometry, wayPoints.reversed(), requested, null))
    check(!drivingWaypointsMatch(geometry, listOf(wayPoints.first(), PolylinePosition(2, 0.0)), requested, null))
    val duplicateVertex = listOf(wayPoints.first(), PolylinePosition(0, 1.0), PolylinePosition(1, 0.0), wayPoints.last())
    check(!drivingWaypointsMatch(geometry, duplicateVertex, requested, null))
    check(!drivingWaypointsMatch(geometry, wayPoints, requested, listOf(origin, retiredDestination)))
}
