package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Point as NativePoint

fun Point.toNative(): NativePoint {
    return NativePoint(latitude.value, longitude.value)
}

fun NativePoint.toCommon(): Point {
    return Point(Latitude(latitude), Longitude(longitude))
}