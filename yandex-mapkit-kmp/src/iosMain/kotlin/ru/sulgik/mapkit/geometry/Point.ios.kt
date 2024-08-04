package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKPoint as NativePoint

public fun Point.toNative(): NativePoint {
    return NativePoint.pointWithLatitude(latitude.value, longitude.value)
}

public fun NativePoint.toCommon(): Point {
    return Point(Latitude(latitude), Longitude(longitude))
}