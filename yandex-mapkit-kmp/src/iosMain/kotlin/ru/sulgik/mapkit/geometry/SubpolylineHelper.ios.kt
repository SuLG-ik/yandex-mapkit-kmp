package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKSubpolylineHelper as NativeSubpolylineHelper

public actual fun Polyline.subpolyline(subpolyline: Subpolyline): Polyline {
    return NativeSubpolylineHelper.subpolylineWithPolyline(toNative(), subpolyline.toNative())
        .toCommon()
}

public actual fun Polyline.subpolylineLength(subpolyline: Subpolyline): Double {
    return NativeSubpolylineHelper.subpolylineLengthWithPolyline(toNative(), subpolyline.toNative())
}
