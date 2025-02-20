package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Geo

public actual object Geo {

    public actual fun distance(firstPoint: Point, secondPoint: Point): Double {
        return Geo.distance(firstPoint.toNative(), secondPoint.toNative())
    }

    public actual fun closestPoint(point: Point, segment: Segment): Point {
        return Geo.closestPoint(point.toNative(), segment.toNative()).toCommon()
    }

    public actual fun pointOnSegmentByFactor(segment: Segment, factor: Double): Point {
        return Geo.pointOnSegmentByFactor(segment.toNative(), factor).toCommon()
    }

    public actual fun course(firstPoint: Point, secondPoint: Point): Double {
        return Geo.course(firstPoint.toNative(), secondPoint.toNative())
    }

    public actual fun advancePolylinePosition(
        polyline: Polyline,
        position: PolylinePosition,
        distance: Double
    ): PolylinePosition {
        return Geo.advancePolylinePosition(polyline.toNative(), position.toNative(), distance).toCommon()
    }
}