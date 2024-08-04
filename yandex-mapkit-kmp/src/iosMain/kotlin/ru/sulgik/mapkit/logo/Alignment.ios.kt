package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoAlignment as NativeAlignment

public fun Alignment.toNative(): NativeAlignment {
    return NativeAlignment.alignmentWithHorizontalAlignment(
        horizontalAlignment = horizontalAlignment.toNative(),
        verticalAlignment = verticalAlignment.toNative()
    )
}

public fun NativeAlignment.toCommon(): Alignment {
    return Alignment(
        horizontalAlignment = horizontalAlignment.toCommon(),
        verticalAlignment = verticalAlignment.toCommon(),
    )
}