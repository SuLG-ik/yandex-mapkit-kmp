package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapCameraCallback as NativeCameraCallback

actual abstract class CameraCallback {

    private val nativeCallback = object : NativeCameraCallback {
        override fun invoke(p1: Boolean) {
            onMoveFinished(p1)
        }
    }

    fun toNative(): NativeCameraCallback {
        return nativeCallback
    }

    actual abstract fun onMoveFinished(completed: Boolean)

}