package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.LocationError as NativeLocationError

public fun LocationError.toNative(): NativeLocationError {
    return NativeLocationError(lateralErrorRange.toNative(), longitudinalErrorRange.toNative())
}

public fun NativeLocationError.toCommon(): LocationError {
    return LocationError(
        lateralErrorRange = lateralErrorRange.toCommon(),
        longitudinalErrorRange = longitudinalErrorRange.toCommon(),
    )
}
