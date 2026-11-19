package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.RouteOptions as NativeRouteOptions

/** Converts this RouteOptions to the native value. */
public fun RouteOptions.toNative(): NativeRouteOptions {
    return NativeRouteOptions(
        fitnessOptions.toNative(),
    )
}

/** Reads this native RouteOptions. */
public fun NativeRouteOptions.toCommon(): RouteOptions {
    return RouteOptions(
        fitnessOptions = fitnessOptions.toCommon(),
    )
}
