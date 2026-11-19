package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.StopFeatureMask as NativeStopFeatureMask

/** Converts this StopFeatureMask to the native value. */
public fun StopFeatureMask.toNative(): NativeStopFeatureMask =
    NativeStopFeatureMask(
        cooled,
        heated,
    )

/** Reads this native StopFeatureMask. */
public fun NativeStopFeatureMask.toCommon(): StopFeatureMask =
    StopFeatureMask(
        cooled = cooled,
        heated = heated,
    )
