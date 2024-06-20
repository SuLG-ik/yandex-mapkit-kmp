package ru.sulgik.mapkit

import YandexMapKit.YMKScreenRect as NativeScreenRect


fun NativeScreenRect.toCommon(): ScreenRect {
    return ScreenRect(
        topLeft = topLeft.toCommon(),
        bottomRight = bottomRight.toCommon(),
    )
}

fun ScreenRect.toNative(): NativeScreenRect {
    return NativeScreenRect.screenRectWithTopLeft(
        topLeft = topLeft.toNative(),
        bottomRight = bottomRight.toNative(),
    )
}
