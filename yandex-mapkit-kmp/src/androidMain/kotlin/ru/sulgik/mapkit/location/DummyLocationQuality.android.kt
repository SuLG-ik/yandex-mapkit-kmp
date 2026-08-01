package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.DummyLocationQuality as NativeDummyLocationQuality

public fun DummyLocationQuality.toNative(): NativeDummyLocationQuality {
    return when (this) {
        DummyLocationQuality.HIGH -> NativeDummyLocationQuality.HIGH
        DummyLocationQuality.LOW -> NativeDummyLocationQuality.LOW
    }
}

public fun NativeDummyLocationQuality.toCommon(): DummyLocationQuality {
    return when (this) {
        NativeDummyLocationQuality.HIGH -> DummyLocationQuality.HIGH
        NativeDummyLocationQuality.LOW -> DummyLocationQuality.LOW
    }
}
