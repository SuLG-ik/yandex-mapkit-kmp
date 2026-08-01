package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.BoundingBoxHelper as NativeBoundingBoxHelper

/**
 * Gets bounds based on a bounding box.
 */
public actual fun BoundingBox.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

/**
 * Gets bounds based on a point.
 */
public actual fun Point.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

/**
 * Gets bounds based on a polyline.
 */
public actual fun Polyline.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

/**
 * Gets bounds based on a linear ring.
 */
public actual fun LinearRing.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

/**
 * Gets bounds based on a polygon.
 */
public actual fun Polygon.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative()).toCommon()
}

/**
 * Gets bounds based on two bounding boxes.
 */
public actual fun BoundingBox.getBounds(second: BoundingBox): BoundingBox {
    return NativeBoundingBoxHelper.getBounds(toNative(), second.toNative()).toCommon()
}
