package ru.sulgik.mapkit.runtime.i18n

import com.yandex.runtime.i18n.SystemOfMeasurement as NativeSystemOfMeasurement

public fun SystemOfMeasurement.toNative(): NativeSystemOfMeasurement {
    return when (this) {
        SystemOfMeasurement.DEFAULT -> NativeSystemOfMeasurement.DEFAULT
        SystemOfMeasurement.METRIC -> NativeSystemOfMeasurement.METRIC
        SystemOfMeasurement.IMPERIAL -> NativeSystemOfMeasurement.IMPERIAL
    }
}

public fun NativeSystemOfMeasurement.toCommon(): SystemOfMeasurement {
    return when (this) {
        NativeSystemOfMeasurement.DEFAULT -> SystemOfMeasurement.DEFAULT
        NativeSystemOfMeasurement.METRIC -> SystemOfMeasurement.METRIC
        NativeSystemOfMeasurement.IMPERIAL -> SystemOfMeasurement.IMPERIAL
    }
}
