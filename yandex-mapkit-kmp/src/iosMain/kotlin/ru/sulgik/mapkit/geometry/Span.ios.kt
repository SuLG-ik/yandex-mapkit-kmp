package ru.sulgik.mapkit.geometry

import YandexMapKit.YMKSpan as NativeSpan

public fun Span.toNative(): NativeSpan {
    return NativeSpan.spanWithHorizontalAngle(
        horizontalAngle = horizontalAngle,
        verticalAngle = verticalAngle,
    )
}

public fun NativeSpan.toCommon(): Span {
    return Span(horizontalAngle = horizontalAngle, verticalAngle = verticalAngle)
}
