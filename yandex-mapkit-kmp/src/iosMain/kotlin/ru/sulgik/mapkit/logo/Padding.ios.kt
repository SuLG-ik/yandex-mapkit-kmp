package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoPadding as NativeLogoPadding

public fun Padding.toNative(): NativeLogoPadding {
    return NativeLogoPadding.paddingWithHorizontalPadding(
        horizontalPadding = horizontalPadding.toULong(),
        verticalPadding = verticalPadding.toULong(),
    )
}

public fun NativeLogoPadding.toCommon(): Padding {
    return Padding(
        horizontalPadding = horizontalPadding.toInt(),
        verticalPadding = verticalPadding.toInt(),
    )
}