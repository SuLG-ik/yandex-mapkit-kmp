package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.map.CameraPosition as NativeCameraPosition


public fun CameraPosition.toNative(): NativeCameraPosition {
    return NativeCameraPosition(target.toNative(), zoom, azimuth, tilt)
}

public fun NativeCameraPosition.toCommon(): CameraPosition {
    return CameraPosition(
        target = target.toCommon(),
        zoom = zoom,
        azimuth = azimuth,
        tilt = tilt,
    )
}
