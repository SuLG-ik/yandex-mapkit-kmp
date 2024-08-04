package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline

public expect class PolylineMapObject : MapObject {

    public var geometry: Polyline

    public var strokeWidth: Float

    public var gradientLength: Float

    public var outlineWidth: Float

    public var outlineColor: Color

    public var isInnerOutlineEnabled: Boolean

    public var turnRadius: Float

    public var dashLength: Float

    public var gapLength: Float

    public var dashOffset: Float

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