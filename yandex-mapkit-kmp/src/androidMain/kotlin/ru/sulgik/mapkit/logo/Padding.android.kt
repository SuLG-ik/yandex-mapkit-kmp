package ru.sulgik.mapkit.logo

import com.yandex.mapkit.logo.Padding as NativePadding

public fun LogoPadding.toNative(): NativePadding {
    return NativePadding(horizontalPadding, verticalPadding)
}

public fun NativePadding.toCommon(): LogoPadding {
    return LogoPadding(
        horizontalPadding = horizontalPadding,
        verticalPadding = verticalPadding
    )
}