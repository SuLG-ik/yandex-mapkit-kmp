package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.HorizontalAlignment as NativeHorizontalAlignment

public fun LogoHorizontalAlignment.toNative(): NativeHorizontalAlignment {
    return when (this) {
        LogoHorizontalAlignment.LEFT -> NativeHorizontalAlignment.LEFT
        LogoHorizontalAlignment.CENTER -> NativeHorizontalAlignment.CENTER
        LogoHorizontalAlignment.RIGHT -> NativeHorizontalAlignment.RIGHT
    }
}

public fun NativeHorizontalAlignment.toCommon(): LogoHorizontalAlignment {
    return when (this) {
        NativeHorizontalAlignment.LEFT -> LogoHorizontalAlignment.LEFT
        NativeHorizontalAlignment.CENTER -> LogoHorizontalAlignment.CENTER
        NativeHorizontalAlignment.RIGHT -> LogoHorizontalAlignment.RIGHT
    }
}