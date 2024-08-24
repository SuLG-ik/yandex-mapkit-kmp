package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.VerticalAlignment as NativeVerticalAlignment


public fun LogoVerticalAlignment.toNative(): NativeVerticalAlignment {
    return when (this) {
        LogoVerticalAlignment.TOP -> NativeVerticalAlignment.TOP
        LogoVerticalAlignment.BOTTOM -> NativeVerticalAlignment.BOTTOM
    }
}

public fun NativeVerticalAlignment.toCommon(): LogoVerticalAlignment {
    return when (this) {
        NativeVerticalAlignment.TOP -> LogoVerticalAlignment.TOP
        NativeVerticalAlignment.BOTTOM -> LogoVerticalAlignment.BOTTOM
    }
}