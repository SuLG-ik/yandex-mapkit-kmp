package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.LocationStatus as NativeLocationStatus

fun LocationStatus.toNative(): NativeLocationStatus {
    return when (this) {
        LocationStatus.NOT_AVAILABLE -> NativeLocationStatus.NOT_AVAILABLE
        LocationStatus.AVAILABLE -> NativeLocationStatus.AVAILABLE
        LocationStatus.RESET -> NativeLocationStatus.RESET
    }
}

fun NativeLocationStatus.toCommon(): LocationStatus {
    return when (this) {
        NativeLocationStatus.NOT_AVAILABLE -> LocationStatus.NOT_AVAILABLE
        NativeLocationStatus.AVAILABLE -> LocationStatus.AVAILABLE
        NativeLocationStatus.RESET -> LocationStatus.RESET
    }
}