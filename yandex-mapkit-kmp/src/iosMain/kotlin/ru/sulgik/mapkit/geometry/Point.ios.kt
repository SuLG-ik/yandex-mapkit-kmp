package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPoint as NativePoint

fun Point.toNative(): NativePoint {
    return NativePoint.pointWithLatitude(latitude.value, longitude.value)
}

fun NativePoint.toCommon(): Point {
    return Point(Latitude(latitude), Longitude(longitude))
}