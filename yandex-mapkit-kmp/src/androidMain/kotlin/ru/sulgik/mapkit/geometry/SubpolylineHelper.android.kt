package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.SubpolylineHelper as NativeSubpolylineHelper

public actual fun Polyline.subpolyline(subpolyline: Subpolyline): Polyline {
    return NativeSubpolylineHelper.subpolyline(toNative(), subpolyline.toNative()).toCommon()
}

public actual fun Polyline.subpolylineLength(subpolyline: Subpolyline): Double {
    return NativeSubpolylineHelper.subpolylineLength(toNative(), subpolyline.toNative())
}
