package ru.sulgik.mapkit.user_location

import YandexMapKit.YMKUserLocationIconType
import YandexMapKit.YMKUserLocationIconType as NativeUserLocationIconType

public fun UserLocationIconType.toNative(): NativeUserLocationIconType {
    return when (this) {
        UserLocationIconType.ARROW -> NativeUserLocationIconType.YMKUserLocationIconTypeArrow
        UserLocationIconType.PIN -> NativeUserLocationIconType.YMKUserLocationIconTypePin
    }
}

public fun NativeUserLocationIconType.toCommon(): UserLocationIconType {
    return when (this) {
        YMKUserLocationIconType.YMKUserLocationIconTypeArrow -> UserLocationIconType.ARROW
        YMKUserLocationIconType.YMKUserLocationIconTypePin -> UserLocationIconType.PIN
        else -> throw IllegalArgumentException("Unknown NativeTextStylePlacement ($this)")
    }
}