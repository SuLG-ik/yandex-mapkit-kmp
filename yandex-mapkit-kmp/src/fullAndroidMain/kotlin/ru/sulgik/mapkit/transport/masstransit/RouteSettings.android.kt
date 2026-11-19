package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.RouteSettings as NativeRouteSettings

/** Converts this RouteSettings to the native value. */
public fun RouteSettings.toNative(): NativeRouteSettings =
    NativeRouteSettings(
        avoidTypes,
        acceptTypes,
    )

/** Reads this native RouteSettings. */
public fun NativeRouteSettings.toCommon(): RouteSettings =
    RouteSettings(
        avoidTypes = avoidTypes,
        acceptTypes = acceptTypes,
    )
