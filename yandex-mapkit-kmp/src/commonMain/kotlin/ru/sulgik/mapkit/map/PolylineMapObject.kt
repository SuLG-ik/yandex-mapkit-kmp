package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline

public expect class PolylineMapObject : MapObject {

    public var geometry: Polyline

    public var style: LineStyle

    @Deprecated("Use style.strokeWidth instead", ReplaceWith("style.strokeWidth"))
    public var strokeWidth: Float

    @Deprecated("Use style.gradientLength instead", ReplaceWith("style.gradientLength"))
    public var gradientLength: Float

    @Deprecated("Use style.outlineWidth instead", ReplaceWith("style.outlineWidth"))
    public var outlineWidth: Float

    @Deprecated("Use style.outlineColor instead", ReplaceWith("style.outlineColor"))
    public var outlineColor: Color

    @Deprecated("Use style.innerOutlineEnabled instead", ReplaceWith("style.innerOutlineEnabled"))
    public var isInnerOutlineEnabled: Boolean

    @Deprecated("Use style.turnRadius instead", ReplaceWith("style.turnRadius"))
    public var turnRadius: Float

    @Deprecated("Use style.dashLength instead", ReplaceWith("style.dashLength"))
    public var dashLength: Float

    @Deprecated("Use style.gapLength instead", ReplaceWith("style.gapLength"))
    public var gapLength: Float

    @Deprecated("Use style.dashOffset instead", ReplaceWith("style.dashOffset"))
    public var dashOffset: Float

    @Deprecated("Use style.arcApproximationStep instead", ReplaceWith("style.arcApproximationStep"))
    public var arcApproximationStep: Float

    public fun select(selectionColor: Color, subpolyline: Subpolyline)

    public fun hide(subpolyline: Subpolyline)

    public fun hide(subpolylines: List<Subpolyline>)

    public fun setStrokeColor(color: Color)

    public fun setStrokeColors(colors: List<Color>, weights: List<Double>)

    public fun setStrokeColors(colors: List<Color>)

    public fun getStrokeColor(segmentIndex: Int): Color

    public fun setPaletteColor(colorIndex: Int, color: Color)

    public fun getPaletteColor(colorIndex: Int): Color

    public fun addArrow(position: PolylinePosition, length: Float, fillColor: Color): Arrow

    public val arrows: List<Arrow>

}