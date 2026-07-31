package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.NativeConvertible
import com.yandex.mapkit.map.CameraListener as NativeCameraListener

public actual abstract class CameraListener actual constructor() : NativeConvertible<NativeCameraListener> {

    private val nativeListener = NativeCameraListener { map, cameraPosition, updateReason, finished ->
        onCameraPositionChanged(
            map.toCommon(),
            cameraPosition.toCommon(),
            updateReason.toCommon(),
            finished
        )
    }

    override fun toNative(): NativeCameraListener {
        return nativeListener
    }

    public actual abstract fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean,
    )

}