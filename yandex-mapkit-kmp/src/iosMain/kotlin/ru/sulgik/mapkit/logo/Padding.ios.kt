package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoPadding as NativeLogoPadding

public fun LogoPadding.toNative(): NativeLogoPadding {
    return NativeLogoPadding.paddingWithHorizontalPadding(
        horizontalPadding = horizontalPadding.toULong(),
        verticalPadding = verticalPadding.toULong(),
    )
}

public fun NativeLogoPadding.toCommon(): LogoPadding {
    return LogoPadding(
        horizontalPadding = horizontalPadding.toInt(),
        verticalPadding = verticalPadding.toInt(),
    )
}