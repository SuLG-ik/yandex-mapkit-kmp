package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoHorizontalAlignment as NativeHorizontalAlignment

fun HorizontalAlignment.toNative(): NativeHorizontalAlignment {
    return when (this) {
        HorizontalAlignment.LEFT -> NativeHorizontalAlignment.YMKLogoHorizontalAlignmentLeft
        HorizontalAlignment.CENTER -> NativeHorizontalAlignment.YMKLogoHorizontalAlignmentCenter
        HorizontalAlignment.RIGHT -> NativeHorizontalAlignment.YMKLogoHorizontalAlignmentRight
    }
}

fun NativeHorizontalAlignment.toCommon(): HorizontalAlignment {
    return when (this) {
        NativeHorizontalAlignment.YMKLogoHorizontalAlignmentLeft -> HorizontalAlignment.LEFT
        NativeHorizontalAlignment.YMKLogoHorizontalAlignmentCenter -> HorizontalAlignment.CENTER
        NativeHorizontalAlignment.YMKLogoHorizontalAlignmentRight -> HorizontalAlignment.RIGHT
        else -> throw IllegalArgumentException("Unknown NativeTextStylePlacement ($this)")
    }
}