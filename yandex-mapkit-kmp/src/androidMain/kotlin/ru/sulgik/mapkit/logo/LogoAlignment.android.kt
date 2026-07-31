package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.Alignment as NativeAlignment

public fun LogoAlignment.toNative(): NativeAlignment {
    return NativeAlignment(horizontalAlignment.toNative(), verticalAlignment.toNative())
}

public fun NativeAlignment.toCommon(): LogoAlignment {
    return LogoAlignment(
        horizontalAlignment = horizontalAlignment.toCommon(),
        verticalAlignment = verticalAlignment.toCommon(),
    )
}
