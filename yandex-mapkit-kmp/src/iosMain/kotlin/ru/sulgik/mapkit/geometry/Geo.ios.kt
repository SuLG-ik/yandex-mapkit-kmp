package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKGeo as NativeGeo

public actual object Geo {

    public actual fun distance(firstPoint: Point, secondPoint: Point): Double {
        return NativeGeo.distanceWithFirstPoint(firstPoint.toNative(), secondPoint.toNative())
    }

    public actual fun closestPoint(point: Point, segment: Segment): Point {
        return NativeGeo.closestPointWithPoint(point.toNative(), segment.toNative()).toCommon()
    }

    public actual fun pointOnSegmentByFactor(segment: Segment, factor: Double): Point {
        return NativeGeo.pointOnSegmentByFactorWithSegment(segment.toNative(), factor).toCommon()
    }

    public actual fun course(firstPoint: Point, secondPoint: Point): Double {
        return NativeGeo.courseWithFirstPoint(firstPoint.toNative(), secondPoint.toNative())
    }
}