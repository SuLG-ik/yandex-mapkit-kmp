package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.FilteringMode as NativeFilteringMode

fun FilteringMode.toNative(): NativeFilteringMode {
    return when (this) {
        FilteringMode.ON -> NativeFilteringMode.ON
        FilteringMode.OFF -> NativeFilteringMode.OFF
    }
}

fun NativeFilteringMode.toCommon(): FilteringMode {
    return when (this) {
        NativeFilteringMode.ON -> FilteringMode.ON
        NativeFilteringMode.OFF -> FilteringMode.OFF
    }
}