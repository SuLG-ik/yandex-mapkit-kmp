package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKRouteOptions as NativeRouteOptions

/** Converts this RouteOptions to the native value. */
public fun RouteOptions.toNative(): NativeRouteOptions =
    NativeRouteOptions.routeOptionsWithFitnessOptions(
        fitnessOptions = fitnessOptions.toNative(),
    )

/** Reads this native RouteOptions. */
public fun NativeRouteOptions.toCommon(): RouteOptions =
    RouteOptions(
        fitnessOptions = fitnessOptions.toCommon(),
    )
