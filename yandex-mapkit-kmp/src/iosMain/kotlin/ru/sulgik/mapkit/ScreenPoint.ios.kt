package ru.sulgik.mapkit

import YandexMapKit.YMKScreenPoint as NativeScreenPoint

public fun ScreenPoint.toNative(): NativeScreenPoint {
    return NativeScreenPoint.screenPointWithX(x = x, y = y)
}

public fun NativeScreenPoint.toCommon(): ScreenPoint {
    return ScreenPoint(x = x, y = y)
}
