package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.toCommon
import YandexMapKit.YMKVisibleRegionUtils as NativeVisibleRegionUtils

/**
 * Converts visible region to polygon geometry.
 */
public actual fun VisibleRegion.toPolygon(): Geometry {
    return NativeVisibleRegionUtils.toPolygonWithVisibleRegion(toNative()).toCommon()
}

/**
 * Returns the bounding box of the visible region.
 */
public actual fun VisibleRegion.getBounds(): BoundingBox {
    return NativeVisibleRegionUtils.getBoundsWithVisibleRegion(toNative()).toCommon()
}
