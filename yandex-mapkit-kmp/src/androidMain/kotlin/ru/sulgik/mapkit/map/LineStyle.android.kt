package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.toArgb
import ru.sulgik.mapkit.toColor
import com.yandex.mapkit.map.LineStyle as NativeLineStyle

public fun LineStyle.toNative(): NativeLineStyle {
    return NativeLineStyle(
        strokeWidth,
        gradientLength,
        outlineColor.toArgb(),
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
        outlineColor = outlineColor.toColor(),
        outlineWidth = outlineWidth,
        innerOutlineEnabled = innerOutlineEnabled,
        turnRadius = turnRadius,
        arcApproximationStep = arcApproximationStep,
        dashLength = dashLength,
        gapLength = gapLength,
        dashOffset = dashOffset,
    )
}