package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Direction as NativeDirection

public fun Direction.toNative(): NativeDirection {
    return NativeDirection(azimuth, tilt)
}

public fun NativeDirection.toCommon(): Direction {
    return Direction(azimuth = azimuth, tilt = tilt)
}
