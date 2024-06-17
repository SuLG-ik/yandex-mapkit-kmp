package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Subpolyline as NativeSubpolyline

fun Subpolyline.toNative(): NativeSubpolyline {
    return NativeSubpolyline(begin.toNative(), end.toNative())
}

fun NativeSubpolyline.toCommon(): Subpolyline {
    return Subpolyline(begin.toCommon(), end.toCommon())
}