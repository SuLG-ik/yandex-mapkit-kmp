package ru.sulgik.mapkit.logo

import YandexMapKit.YMKLogoPadding as NativeLogoPadding

fun Padding.toNative(): NativeLogoPadding {
    return NativeLogoPadding.paddingWithHorizontalPadding(
        horizontalPadding = horizontalPadding.toULong(),
        verticalPadding = verticalPadding.toULong(),
    )
}

fun NativeLogoPadding.toCommon(): Padding {
    return Padding(
        horizontalPadding = horizontalPadding.toInt(),
        verticalPadding = verticalPadding.toInt(),
    )
}