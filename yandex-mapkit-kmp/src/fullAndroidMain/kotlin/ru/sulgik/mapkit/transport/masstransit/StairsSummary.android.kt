package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.StairsSummary as NativeStairsSummary

/** Converts this StairsSummary to the native value. */
public fun StairsSummary.toNative(): NativeStairsSummary =
    NativeStairsSummary(
        numberOfStairs,
        numberOfStairsWithRamp,
    )

/** Reads this native StairsSummary. */
public fun NativeStairsSummary.toCommon(): StairsSummary =
    StairsSummary(
        numberOfStairs = numberOfStairs,
        numberOfStairsWithRamp = numberOfStairsWithRamp,
    )
