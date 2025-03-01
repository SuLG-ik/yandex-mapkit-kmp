package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.toArgb
import ru.sulgik.mapkit.toColor
import com.yandex.mapkit.map.LineStyle as NativeLineStyle

public actual class LineStyle internal constructor(
    private val nativeLineStyle: NativeLineStyle,
) {
    public actual var strokeWidth: Float
        get() = nativeLineStyle.strokeWidth
        set(value) {
            nativeLineStyle.strokeWidth = value
        }
    public actual var gradientLength: Float
        get() = nativeLineStyle.gradientLength
        set(value) {
            nativeLineStyle.gradientLength = value
        }
    public actual var outlineColor: Color
        get() = nativeLineStyle.outlineColor.toColor()
        set(value) {
            nativeLineStyle.outlineColor = value.toArgb()
        }
    public actual var outlineWidth: Float
        get() = nativeLineStyle.outlineWidth
        set(value) {
            nativeLineStyle.outlineWidth = value
        }
    public actual var innerOutlineEnabled: Boolean
        get() = nativeLineStyle.innerOutlineEnabled
        set(value) {
            nativeLineStyle.innerOutlineEnabled = value
        }
    public actual var turnRadius: Float
        get() = nativeLineStyle.turnRadius
        set(value) {
            nativeLineStyle.turnRadius = value
        }
    public actual var arcApproximationStep: Float
        get() = nativeLineStyle.arcApproximationStep
        set(value) {
            nativeLineStyle.arcApproximationStep = value
        }
    public actual var dashLength: Float
        get() = nativeLineStyle.dashLength
        set(value) {
            nativeLineStyle.dashLength = value
        }
    public actual var gapLength: Float
        get() = nativeLineStyle.gapLength
        set(value) {
            nativeLineStyle.gapLength = value
        }
    public actual var dashOffset: Float
        get() = nativeLineStyle.dashOffset
        set(value) {
            nativeLineStyle.dashOffset = value
        }

    public actual constructor(
        strokeWidth: Float,
        gradientLength: Float,
        outlineColor: Color,
        outlineWidth: Float,
        innerOutlineEnabled: Boolean,
        turnRadius: Float,
        arcApproximationStep: Float,
        dashLength: Float,
        gapLength: Float,
        dashOffset: Float
    ) : this(
        NativeLineStyle(
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
    )

    public fun toNative(): NativeLineStyle {
        return nativeLineStyle
    }
}

public fun NativeLineStyle.toCommon(): LineStyle {
    return LineStyle(this)
}
