package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.CameraListener as NativeCameraListener
import com.yandex.mapkit.map.CameraPosition as NativeCameraPosition
import com.yandex.mapkit.map.CameraUpdateReason as NativeCameraUpdateReason
import com.yandex.mapkit.map.Map as NativeMap

actual class CameraListener actual constructor(
    private val onCameraPositionChanged: (
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean,
    ) -> Unit,
) : NativeCameraListener {


    override fun onCameraPositionChanged(
        p0: NativeMap,
        p1: NativeCameraPosition,
        p2: NativeCameraUpdateReason,
        p3: Boolean,
    ) {
        onCameraPositionChanged.invoke(p0.toCommon(), p1.toCommon(), p2.toCommon(), p3)
    }
}