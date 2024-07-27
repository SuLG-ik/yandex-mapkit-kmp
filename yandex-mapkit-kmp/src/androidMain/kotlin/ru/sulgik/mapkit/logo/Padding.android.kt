package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.Padding as NativePadding

fun Padding.toNative(): NativePadding {
    return NativePadding(horizontalPadding, verticalPadding)
}

fun NativePadding.toCommon(): Padding {
    return Padding(
        horizontalPadding = horizontalPadding,
        verticalPadding = verticalPadding
    )
}