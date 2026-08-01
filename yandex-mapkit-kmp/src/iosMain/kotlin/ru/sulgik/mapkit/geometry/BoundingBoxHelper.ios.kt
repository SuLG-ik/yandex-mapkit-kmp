package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKBoundingBoxHelper as NativeBoundingBoxHelper

public actual fun BoundingBox.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithBbox(toNative()).toCommon()
}

public actual fun Point.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithPoint(toNative()).toCommon()
}

public actual fun Polyline.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithPolyline(toNative()).toCommon()
}

public actual fun LinearRing.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithRing(toNative()).toCommon()
}

public actual fun Polygon.getBounds(): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithPolygon(toNative()).toCommon()
}

public actual fun BoundingBox.getBounds(second: BoundingBox): BoundingBox {
    return NativeBoundingBoxHelper.getBoundsWithFirst(toNative(), second.toNative()).toCommon()
}
