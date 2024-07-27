package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoAlignment as NativeAlignment

fun Alignment.toNative(): NativeAlignment {
    return NativeAlignment.alignmentWithHorizontalAlignment(
        horizontalAlignment = horizontalAlignment.toNative(),
        verticalAlignment = verticalAlignment.toNative()
    )
}

fun NativeAlignment.toCommon(): Alignment {
    return Alignment(
        horizontalAlignment = horizontalAlignment.toCommon(),
        verticalAlignment = verticalAlignment.toCommon(),
    )
}