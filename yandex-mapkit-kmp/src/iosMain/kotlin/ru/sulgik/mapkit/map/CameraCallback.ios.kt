package ru.sulgik.mapkit.map

import YandexMapKit.YMKMapCameraCallback as NativeCameraCallback

actual abstract class CameraCallback : NativeCameraCallback {

    actual abstract fun onMoveFinished(completed: Boolean)

    override fun invoke(p1: Boolean) {
        onMoveFinished(p1)
    }

}