package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKDirection as NativeDirection

public fun Direction.toNative(): NativeDirection {
    return NativeDirection.directionWithAzimuth(azimuth = azimuth, tilt = tilt)
}

public fun NativeDirection.toCommon(): Direction {
    return Direction(azimuth = azimuth, tilt = tilt)
}
