package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKLineStyle as NativeLineStyle

public fun LineStyle.toNative(): NativeLineStyle {
    return NativeLineStyle.lineStyleWithStrokeWidth(
        strokeWidth,
        gradientLength,
        outlineColor.toNative(),
        outlineWidth,
        innerOutlineEnabled,
        turnRadius,
        arcApproximationStep,
        dashLength,
        gapLength,
        dashOffset
    )
}

public fun NativeLineStyle.toCommon(): LineStyle {
    return LineStyle(
        strokeWidth = strokeWidth,
        gradientLength = gradientLength,
        outlineColor = outlineColor.toCommon(),
        outlineWidth = outlineWidth,
        innerOutlineEnabled = innerOutlineEnabled,
        turnRadius = turnRadius,
        arcApproximationStep = arcApproximationStep,
        dashLength = dashLength,
        gapLength = gapLength,
        dashOffset = dashOffset,
    )
}