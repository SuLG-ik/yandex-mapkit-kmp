package ru.sulgik.mapkit.location

import YandexMapKit.YMKViewArea as NativeViewArea

public fun ViewArea.toNative(): NativeViewArea {
    return NativeViewArea.viewAreaWithLengthwise(
        lengthwise = lengthwise,
        transverse = transverse,
    )
}

public fun NativeViewArea.toCommon(): ViewArea {
    return ViewArea(lengthwise = lengthwise, transverse = transverse)
}
