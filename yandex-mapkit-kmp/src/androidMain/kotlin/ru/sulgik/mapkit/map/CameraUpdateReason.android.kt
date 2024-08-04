package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.CameraUpdateReason as NativeCameraUpdateReason

public fun NativeCameraUpdateReason.toCommon(): CameraUpdateReason {
    return when (this) {
        NativeCameraUpdateReason.GESTURES -> CameraUpdateReason.GESTURES
        NativeCameraUpdateReason.APPLICATION -> CameraUpdateReason.APPLICATION
    }
}

public fun CameraUpdateReason.toNative(): NativeCameraUpdateReason {
    return when (this) {
        CameraUpdateReason.GESTURES -> NativeCameraUpdateReason.GESTURES
        CameraUpdateReason.APPLICATION -> NativeCameraUpdateReason.APPLICATION
    }
}