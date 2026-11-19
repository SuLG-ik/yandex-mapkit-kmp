package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.transport.masstransit.Weight as NativeWeight

/** Converts this Weight to the native value. */
public fun Weight.toNative(): NativeWeight =
    NativeWeight(
        time.toNative(),
        walkingDistance.toNative(),
        transfersCount,
    )

/** Reads this native Weight. */
public fun NativeWeight.toCommon(): Weight =
    Weight(
        time = time.toCommon(),
        walkingDistance = walkingDistance.toCommon(),
        transfersCount = transfersCount,
    )
