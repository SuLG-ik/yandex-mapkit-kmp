package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationError as NativeLocationError

public fun LocationError.toNative(): NativeLocationError {
    return NativeLocationError.locationErrorWithLateralErrorRange(
        lateralErrorRange = lateralErrorRange.toNative(),
        longitudinalErrorRange = longitudinalErrorRange.toNative(),
    )
}

public fun NativeLocationError.toCommon(): LocationError {
    return LocationError(
        lateralErrorRange = lateralErrorRange.toCommon(),
        longitudinalErrorRange = longitudinalErrorRange.toCommon(),
    )
}
