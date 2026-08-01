package ru.sulgik.mapkit.geometry

import com.yandex.mapkit.geometry.Span as NativeSpan

public fun Span.toNative(): NativeSpan {
    return NativeSpan(horizontalAngle, verticalAngle)
}

public fun NativeSpan.toCommon(): Span {
    return Span(horizontalAngle = horizontalAngle, verticalAngle = verticalAngle)
}
