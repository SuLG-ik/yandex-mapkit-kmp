package ru.sulgik.mapkit

import YandexMapKit.YMKScreenPoint as NativeScreenPoint

fun ScreenPoint.toNative(): NativeScreenPoint {
    return NativeScreenPoint.screenPointWithX(x = x, y = y)
}

fun NativeScreenPoint.toCommon(): ScreenPoint {
    return ScreenPoint(x = x, y = y)
}
