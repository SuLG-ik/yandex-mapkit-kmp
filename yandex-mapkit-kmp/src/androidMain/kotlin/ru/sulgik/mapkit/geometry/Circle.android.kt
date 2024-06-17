package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Circle as NativeCircle

fun Circle.toNative(): NativeCircle {
    return NativeCircle(center.toNative(), radius)
}

fun NativeCircle.toCommon(): Circle {
    return Circle(center.toCommon(), radius)
}