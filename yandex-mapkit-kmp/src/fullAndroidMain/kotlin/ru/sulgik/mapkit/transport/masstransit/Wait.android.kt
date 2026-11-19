package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.Wait as NativeWait

/** Converts this Wait to the native value. */
public fun Wait.toNative(): NativeWait =
    NativeWait(
        dummy,
    )

/** Reads this native Wait. */
public fun NativeWait.toCommon(): Wait =
    Wait(
        dummy = dummy,
    )
