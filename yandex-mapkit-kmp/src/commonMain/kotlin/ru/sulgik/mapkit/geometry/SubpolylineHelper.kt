package ru.sulgik.mapkit.geometry

/**
 * Cuts subpolyline geometry from polyline.
 */
public expect fun Polyline.subpolyline(subpolyline: Subpolyline): Polyline

/**
 * Calculates length of subpolyline geometry.
 */
public expect fun Polyline.subpolylineLength(subpolyline: Subpolyline): Double
