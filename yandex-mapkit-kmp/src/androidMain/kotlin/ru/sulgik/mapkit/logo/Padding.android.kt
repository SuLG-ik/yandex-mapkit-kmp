package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.Padding as NativePadding

public fun Padding.toNative(): NativePadding {
    return NativePadding(horizontalPadding, verticalPadding)
}

public fun NativePadding.toCommon(): Padding {
    return Padding(
        horizontalPadding = horizontalPadding,
        verticalPadding = verticalPadding
    )
}