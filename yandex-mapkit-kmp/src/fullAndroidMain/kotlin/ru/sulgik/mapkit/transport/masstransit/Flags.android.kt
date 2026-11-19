package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.Flags as NativeFlags

/** Converts this Flags to the native value. */
public fun Flags.toNative(): NativeFlags =
    NativeFlags(
        requiresAccessPass,
        hasAutoRoad,
    )

/** Reads this native Flags. */
public fun NativeFlags.toCommon(): Flags =
    Flags(
        requiresAccessPass = requiresAccessPass,
        hasAutoRoad = hasAutoRoad,
    )
