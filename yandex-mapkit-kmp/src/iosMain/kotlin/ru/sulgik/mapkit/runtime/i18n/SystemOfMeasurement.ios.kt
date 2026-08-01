package ru.sulgik.mapkit.runtime.i18n

import YandexMapKit.YRTSystemOfMeasurement as NativeSystemOfMeasurement

public fun SystemOfMeasurement.toNative(): NativeSystemOfMeasurement {
    return when (this) {
        SystemOfMeasurement.DEFAULT -> NativeSystemOfMeasurement.YRTSystemOfMeasurementDefault
        SystemOfMeasurement.METRIC -> NativeSystemOfMeasurement.YRTSystemOfMeasurementMetric
        SystemOfMeasurement.IMPERIAL -> NativeSystemOfMeasurement.YRTSystemOfMeasurementImperial
    }
}

public fun NativeSystemOfMeasurement.toCommon(): SystemOfMeasurement {
    return when (this) {
        NativeSystemOfMeasurement.YRTSystemOfMeasurementDefault -> SystemOfMeasurement.DEFAULT
        NativeSystemOfMeasurement.YRTSystemOfMeasurementMetric -> SystemOfMeasurement.METRIC
        NativeSystemOfMeasurement.YRTSystemOfMeasurementImperial -> SystemOfMeasurement.IMPERIAL
        else -> throw IllegalArgumentException("Unknown NativeSystemOfMeasurement ($this)")
    }
}
