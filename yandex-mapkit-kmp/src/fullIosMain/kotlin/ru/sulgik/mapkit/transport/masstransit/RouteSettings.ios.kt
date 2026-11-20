package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitRouteSettings as NativeRouteSettings

/** Converts this RouteSettings to the native value. */
public fun RouteSettings.toNative(): NativeRouteSettings {
    return NativeRouteSettings.routeSettingsWithAvoidTypes(
        avoidTypes = avoidTypes,
        acceptTypes = acceptTypes,
    )
}

/** Reads this native RouteSettings. */
public fun NativeRouteSettings.toCommon(): RouteSettings {
    return RouteSettings(
        avoidTypes = avoidTypes.map { it as String },
        acceptTypes = acceptTypes.map { it as String },
    )
}
