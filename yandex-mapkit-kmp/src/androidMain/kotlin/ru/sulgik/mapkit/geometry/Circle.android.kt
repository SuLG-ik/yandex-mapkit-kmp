package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Circle as NativeCircle

public fun Circle.toNative(): NativeCircle {
    return NativeCircle(center.toNative(), radius)
}

public fun NativeCircle.toCommon(): Circle {
    return Circle(center.toCommon(), radius)
}