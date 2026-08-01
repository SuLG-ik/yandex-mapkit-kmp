package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoAlignment as NativeAlignment

public fun LogoAlignment.toNative(): NativeAlignment {
    return NativeAlignment.alignmentWithHorizontalAlignment(
        horizontalAlignment = horizontalAlignment.toNative(),
        verticalAlignment = verticalAlignment.toNative(),
    )
}

public fun NativeAlignment.toCommon(): LogoAlignment {
    return LogoAlignment(
        horizontalAlignment = horizontalAlignment.toCommon(),
        verticalAlignment = verticalAlignment.toCommon(),
    )
}
