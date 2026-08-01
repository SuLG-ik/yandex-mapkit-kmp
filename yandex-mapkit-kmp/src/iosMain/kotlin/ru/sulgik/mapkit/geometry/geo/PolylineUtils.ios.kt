package ru.sulgik.mapkit.geometry.geo

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKPolylinePosition as NativePolylinePosition
import YandexMapKit.YMKPolylineUtils as NativePolylineUtils

/**
 * The position of the fork on the road.
 */
@Suppress("UNCHECKED_CAST")
public actual fun positionsOfFork(
    firstPolyline: Polyline,
    firstPolylinePosition: PolylinePosition,
    secondPolyline: Polyline,
    secondPolylinePosition: PolylinePosition,
): List<PolylinePosition> {
    return (
        NativePolylineUtils.positionsOfForkWithFirstPolyline(
            firstPolyline.toNative(),
            firstPolylinePosition.toNative(),
            secondPolyline.toNative(),
            secondPolylinePosition.toNative(),
        ) as List<NativePolylinePosition>
        ).map { it.toCommon() }
}

/**
 * Advance the polyline position by a specified distance in meters.
 */
public actual fun Polyline.advancePolylinePosition(
    position: PolylinePosition,
    distance: Double,
): PolylinePosition {
    return NativePolylineUtils
        .advancePolylinePositionWithPolyline(toNative(), position.toNative(), distance)
        .toCommon()
}

/**
 * The point in the polyline.
 */
public actual fun Polyline.pointByPolylinePosition(position: PolylinePosition): Point {
    return NativePolylineUtils
        .pointByPolylinePositionWithGeometry(toNative(), position.toNative())
        .toCommon()
}

/**
 * The distance in meters between the two positions of the polyline.
 */
public actual fun Polyline.distanceBetweenPolylinePositions(
    from: PolylinePosition,
    to: PolylinePosition,
): Double {
    return NativePolylineUtils
        .distanceBetweenPolylinePositionsWithPolyline(toNative(), from.toNative(), to.toNative())
}

/**
 * Creates [PolylineIndex] for polyline.
 */
public actual fun Polyline.createPolylineIndex(): PolylineIndex {
    return NativePolylineUtils.createPolylineIndexWithPolyline(toNative()).toCommon()
}
