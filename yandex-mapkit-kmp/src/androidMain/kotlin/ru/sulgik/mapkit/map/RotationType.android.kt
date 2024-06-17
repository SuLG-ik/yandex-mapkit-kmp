package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.RotationType as NativeRotationType

fun RotationType.toNative(): NativeRotationType {
    return when (this) {
        RotationType.NO_ROTATION -> NativeRotationType.NO_ROTATION
        RotationType.ROTATE -> NativeRotationType.ROTATE
    }
}

fun NativeRotationType.toCommon(): RotationType {
    return when (this) {
        NativeRotationType.NO_ROTATION -> RotationType.NO_ROTATION
        NativeRotationType.ROTATE -> RotationType.ROTATE
    }
}