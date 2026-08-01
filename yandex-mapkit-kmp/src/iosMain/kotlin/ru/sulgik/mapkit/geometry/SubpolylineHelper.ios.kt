package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKSubpolylineHelper as NativeSubpolylineHelper

/**
 * Cuts subpolyline geometry from polyline.
 */
public actual fun Polyline.subpolyline(subpolyline: Subpolyline): Polyline {
    return NativeSubpolylineHelper.subpolylineWithPolyline(toNative(), subpolyline.toNative())
        .toCommon()
}

/**
 * Calculates length of subpolyline geometry.
 */
public actual fun Polyline.subpolylineLength(subpolyline: Subpolyline): Double {
    return NativeSubpolylineHelper.subpolylineLengthWithPolyline(toNative(), subpolyline.toNative())
}
