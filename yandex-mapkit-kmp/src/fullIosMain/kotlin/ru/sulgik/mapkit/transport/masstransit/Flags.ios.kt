package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitFlags as NativeFlags

/** Converts this Flags to the native value. */
public fun Flags.toNative(): NativeFlags {
    return NativeFlags.flagsWithRequiresAccessPass(
        requiresAccessPass = requiresAccessPass,
        hasAutoRoad = hasAutoRoad,
    )
}

/** Reads this native Flags. */
public fun NativeFlags.toCommon(): Flags {
    return Flags(
        requiresAccessPass = requiresAccessPass,
        hasAutoRoad = hasAutoRoad,
    )
}
