package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.VerticalAlignment as NativeVerticalAlignment


public fun VerticalAlignment.toNative(): NativeVerticalAlignment {
    return when (this) {
        VerticalAlignment.TOP -> NativeVerticalAlignment.TOP
        VerticalAlignment.BOTTOM -> NativeVerticalAlignment.BOTTOM
    }
}

public fun NativeVerticalAlignment.toCommon(): VerticalAlignment {
    return when (this) {
        NativeVerticalAlignment.TOP -> VerticalAlignment.TOP
        NativeVerticalAlignment.BOTTOM -> VerticalAlignment.BOTTOM
    }
}