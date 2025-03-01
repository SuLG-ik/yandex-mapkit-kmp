package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Geo as NativeGeo

public actual object Geo {

    public actual fun distance(firstPoint: Point, secondPoint: Point): Double {
        return NativeGeo.distance(firstPoint.toNative(), secondPoint.toNative())
    }

    public actual fun closestPoint(point: Point, segment: Segment): Point {
        return NativeGeo.closestPoint(point.toNative(), segment.toNative()).toCommon()
    }

    public actual fun pointOnSegmentByFactor(segment: Segment, factor: Double): Point {
        return NativeGeo.pointOnSegmentByFactor(segment.toNative(), factor).toCommon()
    }

    public actual fun course(firstPoint: Point, secondPoint: Point): Double {
        return NativeGeo.course(firstPoint.toNative(), secondPoint.toNative())
    }
}