package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKCircle as NativeCircle

public fun NativeCircle.toCommon(): Circle {
    return Circle(center.toCommon(), radius)
}

public fun Circle.toNative(): NativeCircle {
    return NativeCircle.circleWithCenter(center.toNative(), radius)
}