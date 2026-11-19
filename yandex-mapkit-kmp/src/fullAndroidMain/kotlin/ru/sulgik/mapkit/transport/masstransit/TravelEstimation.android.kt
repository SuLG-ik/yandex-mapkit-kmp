package ru.sulgik.mapkit.transport.masstransit

import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.transport.masstransit.TravelEstimation as NativeTravelEstimation

/** Converts this TravelEstimation to the native value. */
public fun TravelEstimation.toNative(): NativeTravelEstimation =
    NativeTravelEstimation(
        departureTime.toNative(),
        arrivalTime.toNative(),
    )

/** Reads this native TravelEstimation. */
public fun NativeTravelEstimation.toCommon(): TravelEstimation =
    TravelEstimation(
        departureTime = departureTime.toCommon(),
        arrivalTime = arrivalTime.toCommon(),
    )
