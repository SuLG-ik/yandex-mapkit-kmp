package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitWait as NativeWait

/** Converts this Wait to the native value. */
public fun Wait.toNative(): NativeWait =
    NativeWait.waitWithDummy(
        dummy = dummy.toULong(),
    )

/** Reads this native Wait. */
public fun NativeWait.toCommon(): Wait =
    Wait(
        dummy = dummy.toInt(),
    )
