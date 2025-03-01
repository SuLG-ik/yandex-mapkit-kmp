package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color

public expect class LineStyle public constructor(
    strokeWidth: Float = 5.0F,
    gradientLength: Float = 0.0F,
    outlineColor: Color = Color.fromArgb(0),
    outlineWidth: Float = 0.0F,
    innerOutlineEnabled: Boolean = false,
    turnRadius: Float = 10.0F,
    arcApproximationStep: Float = 12.0F,
    dashLength: Float = 0.0F,
    gapLength: Float = 0.0F,
    dashOffset: Float = 0.0F
) {
    public var strokeWidth: Float
    public var gradientLength: Float
    public var outlineColor: Color
    public var outlineWidth: Float
    public var innerOutlineEnabled: Boolean
    public var turnRadius: Float
    public var arcApproximationStep: Float
    public var dashLength: Float
    public var gapLength: Float
    public var dashOffset: Float

}
