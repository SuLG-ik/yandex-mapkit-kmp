package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitStairsSummary as NativeStairsSummary

/** Converts this StairsSummary to the native value. */
public fun StairsSummary.toNative(): NativeStairsSummary =
    NativeStairsSummary.stairsSummaryWithNumberOfStairs(
        numberOfStairs = numberOfStairs.toULong(),
        numberOfStairsWithRamp = numberOfStairsWithRamp.toULong(),
    )

/** Reads this native StairsSummary. */
public fun NativeStairsSummary.toCommon(): StairsSummary =
    StairsSummary(
        numberOfStairs = numberOfStairs.toInt(),
        numberOfStairsWithRamp = numberOfStairsWithRamp.toInt(),
    )
