package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapCameraCallback as NativeCameraCallback

public actual abstract class CameraCallback actual constructor() {

    private val nativeCallback: NativeCameraCallback = { completed -> onMoveFinished(completed) }

    public fun toNative(): NativeCameraCallback {
        return nativeCallback
    }

    public actual abstract fun onMoveFinished(completed: Boolean)
}
