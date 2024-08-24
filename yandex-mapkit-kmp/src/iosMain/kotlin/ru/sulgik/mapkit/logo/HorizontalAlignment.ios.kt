package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoHorizontalAlignment as NativeHorizontalAlignment

public fun LogoHorizontalAlignment.toNative(): NativeHorizontalAlignment {
    return when (this) {
        LogoHorizontalAlignment.LEFT -> NativeHorizontalAlignment.YMKLogoHorizontalAlignmentLeft
        LogoHorizontalAlignment.CENTER -> NativeHorizontalAlignment.YMKLogoHorizontalAlignmentCenter
        LogoHorizontalAlignment.RIGHT -> NativeHorizontalAlignment.YMKLogoHorizontalAlignmentRight
    }
}

public fun NativeHorizontalAlignment.toCommon(): LogoHorizontalAlignment {
    return when (this) {
        NativeHorizontalAlignment.YMKLogoHorizontalAlignmentLeft -> LogoHorizontalAlignment.LEFT
        NativeHorizontalAlignment.YMKLogoHorizontalAlignmentCenter -> LogoHorizontalAlignment.CENTER
        NativeHorizontalAlignment.YMKLogoHorizontalAlignmentRight -> LogoHorizontalAlignment.RIGHT
        else -> throw IllegalArgumentException("Unknown NativeTextStylePlacement ($this)")
    }
}