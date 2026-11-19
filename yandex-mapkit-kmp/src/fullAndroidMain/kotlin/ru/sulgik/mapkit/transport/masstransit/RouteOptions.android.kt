package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.RouteOptions as NativeRouteOptions

/** Converts this RouteOptions to the native value. */
public fun RouteOptions.toNative(): NativeRouteOptions =
    NativeRouteOptions(
        fitnessOptions.toNative(),
    )

/** Reads this native RouteOptions. */
public fun NativeRouteOptions.toCommon(): RouteOptions =
    RouteOptions(
        fitnessOptions = fitnessOptions.toCommon(),
    )
