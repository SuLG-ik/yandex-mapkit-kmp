package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.TransitOptions as NativeTransitOptions

/** Converts this TransitOptions to the native value. */
public fun TransitOptions.toNative(): NativeTransitOptions {
    return NativeTransitOptions(
        avoid,
        timeOptions.toNative(),
    )
}

/** Reads this native TransitOptions. */
public fun NativeTransitOptions.toCommon(): TransitOptions {
    return TransitOptions(
        avoid = avoid,
        timeOptions = timeOptions.toCommon(),
    )
}
