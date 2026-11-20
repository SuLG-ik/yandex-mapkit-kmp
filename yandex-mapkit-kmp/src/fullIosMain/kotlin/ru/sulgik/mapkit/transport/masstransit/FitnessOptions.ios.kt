package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKFitnessOptions as NativeFitnessOptions

/** Converts this FitnessOptions to the native value. */
public fun FitnessOptions.toNative(): NativeFitnessOptions {
    return NativeFitnessOptions.fitnessOptionsWithAvoidSteep(
        avoidSteep = avoidSteep,
        avoidStairs = avoidStairs,
    )
}

/** Reads this native FitnessOptions. */
public fun NativeFitnessOptions.toCommon(): FitnessOptions {
    return FitnessOptions(
        avoidSteep = avoidSteep,
        avoidStairs = avoidStairs,
    )
}
