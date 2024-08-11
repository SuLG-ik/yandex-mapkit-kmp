package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKGeometry as NativeGeometry

public fun NativeGeometry.toCommon(): Geometry {
    return Geometry(
        point = point?.toCommon(),
        polyline = polyline?.toCommon(),
        polygon = polygon?.toCommon(),
        multiPolygon = multiPolygon?.toCommon(),
        boundingBox = boundingBox?.toCommon(),
        circle = circle?.toCommon(),
    )
}

public fun Geometry.toNative(): NativeGeometry {
    return when {
        point != null -> NativeGeometry.geometryWithPoint(point.toNative())
        polyline != null -> NativeGeometry.geometryWithPolyline(polyline.toNative())
        polygon != null -> NativeGeometry.geometryWithPolygon(polygon.toNative())
        multiPolygon != null -> NativeGeometry.geometryWithMultiPolygon(multiPolygon.toNative())
        boundingBox != null -> NativeGeometry.geometryWithBoundingBox(boundingBox.toNative())
        circle != null -> NativeGeometry.geometryWithCircle(circle.toNative())
        else -> throw IllegalStateException("Conversion common $this to native is not available")
    }
}