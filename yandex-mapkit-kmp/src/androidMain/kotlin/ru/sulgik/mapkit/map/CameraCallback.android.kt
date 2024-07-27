package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.Map.CameraCallback as NativeCameraCallback

actual abstract class CameraCallback {

    private val nativeCallback = NativeCameraCallback { onMoveFinished(it) }

    fun toNative(): NativeCameraCallback {
        return nativeCallback
    }

    actual abstract fun onMoveFinished(completed: Boolean)

}