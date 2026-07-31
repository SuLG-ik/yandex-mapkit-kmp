package ru.sulgik.mapkit.location

import YandexMapKit.YMKDummyLocationQuality as NativeDummyLocationQuality

public fun DummyLocationQuality.toNative(): NativeDummyLocationQuality {
    return when (this) {
        DummyLocationQuality.HIGH -> NativeDummyLocationQuality.YMKDummyLocationQualityHigh
        DummyLocationQuality.LOW -> NativeDummyLocationQuality.YMKDummyLocationQualityLow
    }
}

public fun NativeDummyLocationQuality.toCommon(): DummyLocationQuality {
    return when (this) {
        NativeDummyLocationQuality.YMKDummyLocationQualityHigh -> DummyLocationQuality.HIGH
        NativeDummyLocationQuality.YMKDummyLocationQualityLow -> DummyLocationQuality.LOW
        else -> throw IllegalArgumentException("Unknown NativeDummyLocationQuality ($this)")
    }
}
