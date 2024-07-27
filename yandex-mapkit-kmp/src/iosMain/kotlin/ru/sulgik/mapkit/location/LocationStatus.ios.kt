package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationStatus as NativeLocationStatus

fun LocationStatus.toNative(): NativeLocationStatus {
    return when (this) {
        LocationStatus.NOT_AVAILABLE -> NativeLocationStatus.YMKLocationStatusNotAvailable
        LocationStatus.AVAILABLE -> NativeLocationStatus.YMKLocationStatusAvailable
        LocationStatus.RESET -> NativeLocationStatus.YMKLocationStatusReset
    }
}

fun NativeLocationStatus.toCommon(): LocationStatus {
    return when (this) {
        NativeLocationStatus.YMKLocationStatusAvailable -> LocationStatus.AVAILABLE
        NativeLocationStatus.YMKLocationStatusReset -> LocationStatus.RESET
        NativeLocationStatus.YMKLocationStatusNotAvailable -> LocationStatus.NOT_AVAILABLE
        else -> throw IllegalArgumentException("Unknown NativeLocationStatus ($this)")
    }
}