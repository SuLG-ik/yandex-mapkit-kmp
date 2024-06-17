package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import YandexMapKit.YMKMapCameraCallback as NativeCameraCallback

actual abstract class CameraCallback: NativeCameraCallback, NSObject() {

    actual abstract fun onMoveFinished(completed: Boolean)

    override fun invoke(p1: Boolean) {
        onMoveFinished(p1)
    }

}