package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKSubpolyline as NativeSubpolyline

fun Subpolyline.toNative(): NativeSubpolyline {
    return NativeSubpolyline.subpolylineWithBegin(begin = begin.toNative(), end = end.toNative())
}

fun NativeSubpolyline.toCommon(): Subpolyline {
    return Subpolyline(begin = begin.toCommon(), end = end.toCommon())
}