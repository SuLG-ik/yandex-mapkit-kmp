package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKClosestPoint
import YandexMapKit.YMKCourse
import YandexMapKit.YMKDistance
import YandexMapKit.YMKPointOnSegmentByFactor
import YandexMapKit.YMKPolylineUtils

public actual object Geo {

    public actual fun distance(firstPoint: Point, secondPoint: Point): Double {
        return YMKDistance(firstPoint.toNative(), secondPoint.toNative())
    }

    public actual fun closestPoint(point: Point, segment: Segment): Point {
        return YMKClosestPoint(point.toNative(), segment.toNative())!!.toCommon()
    }

    public actual fun pointOnSegmentByFactor(segment: Segment, factor: Double): Point {
        return YMKPointOnSegmentByFactor(segment.toNative(), factor)!!.toCommon()
    }

    public actual fun course(firstPoint: Point, secondPoint: Point): Double {
        return YMKCourse(firstPoint.toNative(), secondPoint.toNative())
    }

    public actual fun advancePolylinePosition(
        polyline: Polyline,
        position: PolylinePosition,
        distance: Double
    ): PolylinePosition {
        return YMKPolylineUtils.advancePolylinePositionWithPolyline(
            polyline = polyline.toNative(),
            position = position.toNative(),
            distance = distance,
        ).toCommon()
    }
}