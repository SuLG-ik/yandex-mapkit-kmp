package ru.sulgik.mapkit.transport.masstransit

import com.yandex.mapkit.transport.masstransit.FitnessType as NativeFitnessType

/** Converts this fitness type to MapKit. */
public fun FitnessType.toNative(): NativeFitnessType =
    when (this) {
        FitnessType.PEDESTRIAN -> NativeFitnessType.PEDESTRIAN
        FitnessType.BICYCLE -> NativeFitnessType.BICYCLE
    }

/** Reads this native fitness type. */
public fun NativeFitnessType.toCommon(): FitnessType =
    when (this) {
        NativeFitnessType.PEDESTRIAN -> FitnessType.PEDESTRIAN
        NativeFitnessType.BICYCLE -> FitnessType.BICYCLE
    }
