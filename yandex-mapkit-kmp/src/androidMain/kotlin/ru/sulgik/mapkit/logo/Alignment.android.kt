package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.Alignment as NativeAlignment

public fun LogoAlignment.toNative() : NativeAlignment {
    return NativeAlignment(horizontal.toNative(), vertical.toNative())
}

public fun NativeAlignment.toCommon(): LogoAlignment {
    return LogoAlignment(
        horizontal = horizontalAlignment.toCommon(),
        vertical = verticalAlignment.toCommon(),
    )
}