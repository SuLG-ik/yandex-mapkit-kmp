package ru.sulgik.mapkit

import com.yandex.mapkit.ScreenPoint as NativeScreenPoint

fun ScreenPoint.toNative(): NativeScreenPoint {
    return NativeScreenPoint(x, y)
}

fun NativeScreenPoint.toCommon(): ScreenPoint {
    return ScreenPoint(x, y)
}