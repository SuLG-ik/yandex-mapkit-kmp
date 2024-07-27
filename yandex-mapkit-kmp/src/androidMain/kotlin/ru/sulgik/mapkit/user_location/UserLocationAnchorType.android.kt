package ru.sulgik.mapkit.user_location

import com.yandex.mapkit.user_location.UserLocationAnchorType as NativeUserLocationAnchorType

fun UserLocationAnchorType.toNative(): NativeUserLocationAnchorType {
    return when (this) {
        UserLocationAnchorType.NORMAL -> NativeUserLocationAnchorType.NORMAL
        UserLocationAnchorType.COURSE -> NativeUserLocationAnchorType.COURSE
    }
}

fun NativeUserLocationAnchorType.toCommon(): UserLocationAnchorType {
    return when (this) {
        NativeUserLocationAnchorType.NORMAL -> UserLocationAnchorType.NORMAL
        NativeUserLocationAnchorType.COURSE -> UserLocationAnchorType.COURSE
    }
}