package ru.sulgik.mapkit.geometry

/**
 * Gets bounds based on a bounding box.
 */
public expect fun BoundingBox.getBounds(): BoundingBox

/**
 * Gets bounds based on a point.
 */
public expect fun Point.getBounds(): BoundingBox

/**
 * Gets bounds based on a polyline.
 */
public expect fun Polyline.getBounds(): BoundingBox

/**
 * Gets bounds based on a linear ring.
 */
public expect fun LinearRing.getBounds(): BoundingBox

/**
 * Gets bounds based on a polygon.
 */
public expect fun Polygon.getBounds(): BoundingBox

/**
 * Gets bounds based on two bounding boxes.
 */
public expect fun BoundingBox.getBounds(second: BoundingBox): BoundingBox
