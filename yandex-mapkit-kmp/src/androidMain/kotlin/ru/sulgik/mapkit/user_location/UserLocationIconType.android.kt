package ru.sulgik.mapkit.user_location

import com.yandex.mapkit.user_location.UserLocationIconType as NativeUserLocationIconType

public fun UserLocationIconType.toNative(): NativeUserLocationIconType {
    return when (this) {
        UserLocationIconType.ARROW -> NativeUserLocationIconType.ARROW
        UserLocationIconType.PIN -> NativeUserLocationIconType.PIN
    }
}

public fun NativeUserLocationIconType.toCommon(): UserLocationIconType {
    return when (this) {
        NativeUserLocationIconType.ARROW -> UserLocationIconType.ARROW
        NativeUserLocationIconType.PIN -> UserLocationIconType.PIN
    }
}