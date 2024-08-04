package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoVerticalAlignment
import YandexMapKit.YMKLogoVerticalAlignment as NativeVerticalAlignment

public fun VerticalAlignment.toNative(): NativeVerticalAlignment {
    return when (this) {
        VerticalAlignment.TOP -> NativeVerticalAlignment.YMKLogoVerticalAlignmentTop
        VerticalAlignment.BOTTOM -> NativeVerticalAlignment.YMKLogoVerticalAlignmentBottom
    }
}

public fun NativeVerticalAlignment.toCommon(): VerticalAlignment {
    return when (this) {
        YMKLogoVerticalAlignment.YMKLogoVerticalAlignmentTop -> VerticalAlignment.TOP
        YMKLogoVerticalAlignment.YMKLogoVerticalAlignmentBottom -> VerticalAlignment.BOTTOM
        else -> throw IllegalArgumentException("Unknown NativeTextStylePlacement ($this)")
    }
}