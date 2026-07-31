package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Geometry

/**
 * Converts visible region to polygon geometry.
 */
public expect fun VisibleRegion.toPolygon(): Geometry

/**
 * Returns the bounding box of the visible region.
 */
public expect fun VisibleRegion.getBounds(): BoundingBox
