package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapCameraCallback as NativeCameraCallback

public actual abstract class CameraCallback {

    private val nativeCallback = object : ((Boolean) -> Unit) {
        override fun invoke(p1: Boolean) {
            onMoveFinished(p1)
        }
    }

    public fun toNative(): NativeCameraCallback {
        return nativeCallback
    }

    public actual abstract fun onMoveFinished(completed: Boolean)

}