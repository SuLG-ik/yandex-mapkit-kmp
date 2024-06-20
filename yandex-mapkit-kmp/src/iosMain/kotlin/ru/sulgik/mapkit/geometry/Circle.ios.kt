package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKCircle as NativeCircle

fun NativeCircle.toCommon(): Circle {
    return Circle(center.toCommon(), radius)
}

fun Circle.toNative(): NativeCircle {
    return NativeCircle.circleWithCenter(center.toNative(), radius)
}