package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.CameraListener
import com.yandex.mapkit.map.CameraListener as NativeCameraListener

public actual abstract class CameraListener actual constructor() {

    private val nativeListener = NativeCameraListener { map, cameraPosition, updateReason, finished ->
        onCameraPositionChanged(
            map.toCommon(),
            cameraPosition.toCommon(),
            updateReason.toCommon(),
            finished
        )
    }

    public fun toNative(): CameraListener {
        return nativeListener
    }

    public actual abstract fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean,
    )

}