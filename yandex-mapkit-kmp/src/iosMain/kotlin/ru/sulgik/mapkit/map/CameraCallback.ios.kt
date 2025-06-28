package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapCameraCallback as NativeCameraCallback

public actual abstract class CameraCallback {

    public fun toNative(): NativeCameraCallback {
        return ::onMoveFinished
    }

    public actual abstract fun onMoveFinished(completed: Boolean)

}