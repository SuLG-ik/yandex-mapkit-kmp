package ru.sulgik.mapkit.geometry.geo

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition

/**
 * The position of the fork on the road.
 */
public expect fun positionsOfFork(
    firstPolyline: Polyline,
    firstPolylinePosition: PolylinePosition,
    secondPolyline: Polyline,
    secondPolylinePosition: PolylinePosition,
): List<PolylinePosition>

/**
 * Advance the polyline position by a specified distance in meters.
 */
public expect fun Polyline.advancePolylinePosition(
    position: PolylinePosition,
    distance: Double,
): PolylinePosition

/**
 * The point in the polyline.
 */
public expect fun Polyline.pointByPolylinePosition(position: PolylinePosition): Point

/**
 * The distance in meters between the two positions of the polyline.
 */
public expect fun Polyline.distanceBetweenPolylinePositions(
    from: PolylinePosition,
    to: PolylinePosition,
): Double

/**
 * Creates [PolylineIndex] for polyline.
 */
public expect fun Polyline.createPolylineIndex(): PolylineIndex
