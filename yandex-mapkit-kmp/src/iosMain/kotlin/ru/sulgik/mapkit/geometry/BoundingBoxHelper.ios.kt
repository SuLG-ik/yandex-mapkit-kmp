package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKBoundingBoxHelper as NativeBoundingBoxHelper

/**
 * Gets bounds based on a bounding box.
 */
public actual fun BoundingBox.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithBbox(toNative()).toCommon()
}

/**
 * Gets bounds based on a point.
 */
public actual fun Point.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithPoint(toNative()).toCommon()
}

/**
 * Gets bounds based on a polyline.
 */
public actual fun Polyline.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithPolyline(toNative()).toCommon()
}

/**
 * Gets bounds based on a linear ring.
 */
public actual fun LinearRing.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithRing(toNative()).toCommon()
}

/**
 * Gets bounds based on a polygon.
 */
public actual fun Polygon.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithPolygon(toNative()).toCommon()
}

/**
 * Gets bounds based on two bounding boxes.
 */
public actual fun BoundingBox.getBounds(second: BoundingBox): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithFirst(toNative(), second.toNative()).toCommon()
}
