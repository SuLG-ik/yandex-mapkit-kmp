package ru.sulgik.mapkit

import com.yandex.mapkit.ScreenRect as NativeScreenRect

fun ScreenRect.toNative(): NativeScreenRect {
    return NativeScreenRect(topLeft.toNative(), bottomRight.toNative())
}

fun NativeScreenRect.toCommon(): ScreenRect {
    return ScreenRect(topLeft.toCommon(), bottomRight.toCommon())
}