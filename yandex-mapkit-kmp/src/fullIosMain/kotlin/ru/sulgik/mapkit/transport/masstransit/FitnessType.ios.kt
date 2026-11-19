package ru.sulgik.mapkit.transport.masstransit

import YandexMapKit.YMKMasstransitFitnessType as NativeFitnessType

/** Converts this fitness type to MapKit. */
public fun FitnessType.toNative(): NativeFitnessType {
    return when (this) {
        FitnessType.PEDESTRIAN -> NativeFitnessType.YMKMasstransitFitnessTypePedestrian
        FitnessType.BICYCLE -> NativeFitnessType.YMKMasstransitFitnessTypeBicycle
    }
}

/** Reads this native fitness type. */
public fun NativeFitnessType.toCommon(): FitnessType {
    return when (this) {
        NativeFitnessType.YMKMasstransitFitnessTypePedestrian -> FitnessType.PEDESTRIAN
        NativeFitnessType.YMKMasstransitFitnessTypeBicycle -> FitnessType.BICYCLE
        else -> throw IllegalArgumentException("Unknown NativeFitnessType ($this)")
    }
}
