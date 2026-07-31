package ru.sulgik.mapkit.map

import YandexMapKit.YMKRotationType as NativeRotationType

public fun RotationType.toNative(): NativeRotationType {
    return when (this) {
        RotationType.NO_ROTATION -> NativeRotationType.YMKRotationTypeNoRotation
        RotationType.ROTATE -> NativeRotationType.YMKRotationTypeRotate
    }
}

public fun NativeRotationType.toCommon(): RotationType {
    return when (this) {
        NativeRotationType.YMKRotationTypeNoRotation -> RotationType.NO_ROTATION
        NativeRotationType.YMKRotationTypeRotate -> RotationType.ROTATE
        else -> throw IllegalArgumentException("Unknown NativeRotationType ($this)")
    }
}
