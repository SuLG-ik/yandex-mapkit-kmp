package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.HorizontalAlignment as NativeHorizontalAlignment

fun HorizontalAlignment.toNative(): NativeHorizontalAlignment {
    return when (this) {
        HorizontalAlignment.LEFT -> NativeHorizontalAlignment.LEFT
        HorizontalAlignment.CENTER -> NativeHorizontalAlignment.CENTER
        HorizontalAlignment.RIGHT -> NativeHorizontalAlignment.RIGHT
    }
}

fun NativeHorizontalAlignment.toCommon(): HorizontalAlignment {
    return when (this) {
        NativeHorizontalAlignment.LEFT -> HorizontalAlignment.LEFT
        NativeHorizontalAlignment.CENTER -> HorizontalAlignment.CENTER
        NativeHorizontalAlignment.RIGHT -> HorizontalAlignment.RIGHT
    }
}