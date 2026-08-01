package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.Map.CameraCallback as NativeCameraCallback

public actual abstract class CameraCallback actual constructor() {

    private val nativeCallback = NativeCameraCallback { onMoveFinished(it) }

    public fun toNative(): NativeCameraCallback {
        return nativeCallback
    }

    public actual abstract fun onMoveFinished(completed: Boolean)
}
