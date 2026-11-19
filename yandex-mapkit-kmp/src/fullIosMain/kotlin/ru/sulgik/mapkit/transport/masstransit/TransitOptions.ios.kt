package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKTransitOptions as NativeTransitOptions

/** Converts this TransitOptions to the native value. */
public fun TransitOptions.toNative(): NativeTransitOptions =
    NativeTransitOptions.transitOptionsWithAvoid(
        avoid = avoid.toUInt().toULong(),
        timeOptions = timeOptions.toNative(),
    )

/** Reads this native TransitOptions. */
public fun NativeTransitOptions.toCommon(): TransitOptions =
    TransitOptions(
        avoid = avoid.toInt(),
        timeOptions = timeOptions.toCommon(),
    )
