package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import YandexMapKit.YMKCameraPosition as NativeCameraPosition
import YandexMapKit.YMKCameraUpdateReason as NativeCameraUpdateReason
import YandexMapKit.YMKMap as NativeMap
import YandexMapKit.YMKMapCameraListenerProtocol as NativeCameraListener

actual class CameraListener actual constructor(
    private val onCameraPositionChanged: (
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean,
    ) -> Unit,
) : NativeCameraListener, NSObject() {

    override fun onCameraPositionChangedWithMap(
        map: NativeMap,
        cameraPosition: NativeCameraPosition,
        cameraUpdateReason: NativeCameraUpdateReason,
        finished: Boolean,
    ) {
        onCameraPositionChanged.invoke(
            map.toCommon(),
            cameraPosition.toCommon(),
            cameraUpdateReason.toCommon(),
            finished
        )
    }

}