package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationFilteringMode as NativeFilteringMode

public fun FilteringMode.toNative(): NativeFilteringMode {
    return when (this) {
        FilteringMode.ON -> NativeFilteringMode.YMKLocationFilteringModeOn
        FilteringMode.OFF -> NativeFilteringMode.YMKLocationFilteringModeOff
    }
}

public fun NativeFilteringMode.toCommon(): FilteringMode {
    return when (this) {
        NativeFilteringMode.YMKLocationFilteringModeOn -> FilteringMode.ON
        NativeFilteringMode.YMKLocationFilteringModeOff -> FilteringMode.OFF
        else -> throw IllegalArgumentException("Unknown NativeFilteringMode ($this)")
    }
}