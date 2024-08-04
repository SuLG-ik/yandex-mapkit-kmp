package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Geometry as NativeGeometry

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
        point != null -> NativeGeometry.fromPoint(point.toNative())
        polyline != null -> NativeGeometry.fromPolyline(polyline.toNative())
        polygon != null -> NativeGeometry.fromPolygon(polygon.toNative())
        multiPolygon != null -> NativeGeometry.fromMultiPolygon(multiPolygon.toNative())
        boundingBox != null -> NativeGeometry.fromBoundingBox(boundingBox.toNative())
        circle != null -> NativeGeometry.fromCircle(circle.toNative())
        else -> throw IllegalStateException("Conversion common $this to native is not available")
    }
}