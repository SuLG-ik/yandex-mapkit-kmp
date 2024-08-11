package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKCameraPosition as NativeCameraPosition

public fun CameraPosition.toNative(): NativeCameraPosition {
    return NativeCameraPosition.cameraPositionWithTarget(target.toNative(), zoom, azimuth, tilt)
}

public fun NativeCameraPosition.toCommon(): CameraPosition {
    return CameraPosition(target.toCommon(), zoom, azimuth, tilt)
}