package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.Rect as NativeRect

public fun Rect.toNative(): NativeRect {
    return NativeRect(min.toNative(), max.toNative())
}

public fun NativeRect.toCommon(): Rect {
    return Rect(min.toCommon(), max.toCommon())
}