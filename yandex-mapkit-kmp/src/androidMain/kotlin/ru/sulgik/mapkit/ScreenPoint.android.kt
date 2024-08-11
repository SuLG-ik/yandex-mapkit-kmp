package ru.sulgik.mapkit

import com.yandex.mapkit.ScreenPoint as NativeScreenPoint

public fun ScreenPoint.toNative(): NativeScreenPoint {
    return NativeScreenPoint(x, y)
}

public fun NativeScreenPoint.toCommon(): ScreenPoint {
    return ScreenPoint(x, y)
}