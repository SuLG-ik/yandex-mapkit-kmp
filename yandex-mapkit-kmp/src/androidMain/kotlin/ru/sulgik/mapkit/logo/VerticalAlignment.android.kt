package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.VerticalAlignment as NativeVerticalAlignment


fun VerticalAlignment.toNative(): NativeVerticalAlignment {
    return when (this) {
        VerticalAlignment.TOP -> NativeVerticalAlignment.TOP
        VerticalAlignment.BOTTOM -> NativeVerticalAlignment.BOTTOM
    }
}

fun NativeVerticalAlignment.toCommon(): VerticalAlignment {
    return when (this) {
        NativeVerticalAlignment.TOP -> VerticalAlignment.TOP
        NativeVerticalAlignment.BOTTOM -> VerticalAlignment.BOTTOM
    }
}