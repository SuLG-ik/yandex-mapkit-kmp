package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.ViewArea as NativeViewArea

public fun ViewArea.toNative(): NativeViewArea {
    return NativeViewArea(lengthwise, transverse)
}

public fun NativeViewArea.toCommon(): ViewArea {
    return ViewArea(lengthwise = lengthwise, transverse = transverse)
}
