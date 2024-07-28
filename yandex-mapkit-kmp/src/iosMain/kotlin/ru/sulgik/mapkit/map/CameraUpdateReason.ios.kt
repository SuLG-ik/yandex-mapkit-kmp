package ru.sulgik.mapkit.map

import YandexMapKit.YMKCameraUpdateReason as NativeCameraUpdateReason


fun NativeCameraUpdateReason.toCommon(): CameraUpdateReason {
    return when (this) {
        NativeCameraUpdateReason.YMKCameraUpdateReasonGestures -> CameraUpdateReason.GESTURES
        NativeCameraUpdateReason.YMKCameraUpdateReasonApplication -> CameraUpdateReason.APPLICATION
        else -> throw IllegalArgumentException("Unknown NativeCameraUpdateReason ($this)")
    }
}

fun CameraUpdateReason.toNative(): NativeCameraUpdateReason {
    return when (this) {
        CameraUpdateReason.GESTURES -> NativeCameraUpdateReason.YMKCameraUpdateReasonGestures
        CameraUpdateReason.APPLICATION -> NativeCameraUpdateReason.YMKCameraUpdateReasonApplication
    }
}