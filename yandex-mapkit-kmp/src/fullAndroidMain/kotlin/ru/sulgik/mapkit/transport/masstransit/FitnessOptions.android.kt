package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.FitnessOptions as NativeFitnessOptions

/** Converts this FitnessOptions to the native value. */
public fun FitnessOptions.toNative(): NativeFitnessOptions {
    return NativeFitnessOptions(
        avoidSteep,
        avoidStairs,
    )
}

/** Reads this native FitnessOptions. */
public fun NativeFitnessOptions.toCommon(): FitnessOptions {
    return FitnessOptions(
        avoidSteep = avoidSteep,
        avoidStairs = avoidStairs,
    )
}
