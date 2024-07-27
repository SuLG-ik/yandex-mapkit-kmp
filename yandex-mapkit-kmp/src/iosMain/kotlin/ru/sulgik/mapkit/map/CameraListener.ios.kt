package ru.sulgik.mapkit.map

import platform.darwin.NSObject
import YandexMapKit.YMKCameraPosition as NativeCameraPosition
import YandexMapKit.YMKCameraUpdateReason as NativeCameraUpdateReason
import YandexMapKit.YMKMap as NativeMap
import YandexMapKit.YMKMapCameraListenerProtocol as NativeCameraListener

actual abstract class CameraListener actual constructor() {

    private val nativeListener = object : NativeCameraListener, NSObject() {
        override fun onCameraPositionChangedWithMap(
            map: NativeMap,
            cameraPosition: NativeCameraPosition,
            cameraUpdateReason: NativeCameraUpdateReason,
            finished: Boolean,
        ) {
            onCameraPositionChanged(
                map.toCommon(),
                cameraPosition.toCommon(),
                cameraUpdateReason.toCommon(),
                finished
            )
        }
    }

    fun toNative(): NativeCameraListener {
        return nativeListener
    }


    actual abstract fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean,
    )
}