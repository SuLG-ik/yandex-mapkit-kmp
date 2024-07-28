package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.CameraUpdateReason as NativeCameraUpdateReason

fun NativeCameraUpdateReason.toCommon(): CameraUpdateReason {
    return when (this) {
        NativeCameraUpdateReason.GESTURES -> CameraUpdateReason.GESTURES
        NativeCameraUpdateReason.APPLICATION -> CameraUpdateReason.APPLICATION
    }
}

fun CameraUpdateReason.toNative(): NativeCameraUpdateReason {
    return when (this) {
        CameraUpdateReason.GESTURES -> NativeCameraUpdateReason.GESTURES
        CameraUpdateReason.APPLICATION -> NativeCameraUpdateReason.APPLICATION
    }
}