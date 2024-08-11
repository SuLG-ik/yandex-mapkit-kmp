package ru.sulgik.mapkit

import YandexMapKit.YMKScreenRect as NativeScreenRect

public fun NativeScreenRect.toCommon(): ScreenRect {
    return ScreenRect(
        topLeft = topLeft.toCommon(),
        bottomRight = bottomRight.toCommon(),
    )
}

public fun ScreenRect.toNative(): NativeScreenRect {
    return NativeScreenRect.screenRectWithTopLeft(
        topLeft = topLeft.toNative(),
        bottomRight = bottomRight.toNative(),
    )
}
