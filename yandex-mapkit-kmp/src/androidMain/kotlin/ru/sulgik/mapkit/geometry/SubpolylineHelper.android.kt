package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.SubpolylineHelper as NativeSubpolylineHelper

/**
 * Cuts subpolyline geometry from polyline.
 */
public actual fun Polyline.subpolyline(subpolyline: Subpolyline): Polyline {
    return NativeSubpolylineHelper.subpolyline(toNative(), subpolyline.toNative()).toCommon()
}

/**
 * Calculates length of subpolyline geometry.
 */
public actual fun Polyline.subpolylineLength(subpolyline: Subpolyline): Double {
    return NativeSubpolylineHelper.subpolylineLength(toNative(), subpolyline.toNative())
}
