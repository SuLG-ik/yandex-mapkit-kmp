package ru.sulgik.mapkit.user_location

import com.yandex.mapkit.user_location.UserLocationAnchorType as NativeUserLocationAnchorType

public fun UserLocationAnchorType.toNative(): NativeUserLocationAnchorType {
    return when (this) {
        UserLocationAnchorType.NORMAL -> NativeUserLocationAnchorType.NORMAL
        UserLocationAnchorType.COURSE -> NativeUserLocationAnchorType.COURSE
    }
}

public fun NativeUserLocationAnchorType.toCommon(): UserLocationAnchorType {
    return when (this) {
        NativeUserLocationAnchorType.NORMAL -> UserLocationAnchorType.NORMAL
        NativeUserLocationAnchorType.COURSE -> UserLocationAnchorType.COURSE
    }
}