package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoAlignment as NativeAlignment

public fun LogoAlignment.toNative(): NativeAlignment {
    return NativeAlignment.alignmentWithHorizontalAlignment(
        horizontalAlignment = horizontal.toNative(),
        verticalAlignment = vertical.toNative()
    )
}

public fun NativeAlignment.toCommon(): LogoAlignment {
    return LogoAlignment(
        horizontal = horizontalAlignment.toCommon(),
        vertical = verticalAlignment.toCommon(),
    )
}