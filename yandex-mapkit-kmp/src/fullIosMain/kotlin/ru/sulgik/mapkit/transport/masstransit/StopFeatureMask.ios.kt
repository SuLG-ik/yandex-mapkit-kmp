package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitStopFeatureMask as NativeStopFeatureMask

/** Converts this StopFeatureMask to the native value. */
public fun StopFeatureMask.toNative(): NativeStopFeatureMask {
    return NativeStopFeatureMask.stopFeatureMaskWithCooled(
        cooled = cooled,
        heated = heated,
    )
}

/** Reads this native StopFeatureMask. */
public fun NativeStopFeatureMask.toCommon(): StopFeatureMask {
    return StopFeatureMask(
        cooled = cooled,
        heated = heated,
    )
}
