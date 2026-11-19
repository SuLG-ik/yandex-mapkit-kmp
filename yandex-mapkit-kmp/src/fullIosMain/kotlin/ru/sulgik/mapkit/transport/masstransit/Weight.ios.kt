package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKMasstransitWeight as NativeWeight

/** Converts this Weight to the native value. */
public fun Weight.toNative(): NativeWeight {
    return NativeWeight.weightWithTime(
        time = time.toNative(),
        walkingDistance = walkingDistance.toNative(),
        transfersCount = transfersCount.toULong(),
    )
}

/** Reads this native Weight. */
public fun NativeWeight.toCommon(): Weight {
    return Weight(
        time = time.toCommon(),
        walkingDistance = walkingDistance.toCommon(),
        transfersCount = transfersCount.toInt(),
    )
}
