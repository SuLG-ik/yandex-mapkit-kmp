package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline

expect class PolylineMapObject : MapObject {

    var geometry: Polyline

    var strokeWidth: Float

    var gradientLength: Float

    var outlineWidth: Float

    var outlineColor: Color

    var isInnerOutlineEnabled: Boolean

    var turnRadius: Float

    var dashLength: Float

    var gapLength: Float

    var dashOffset: Float

    fun select(selectionColor: Color, subpolyline: Subpolyline)

    fun hide(subpolyline: Subpolyline)

    fun hide(subpolylines: List<Subpolyline>)

    fun setStrokeColors(colors: List<Color>, weights: List<Double>)

    fun setStrokeColors(colors: List<Color>)

    fun getStrokeColor(segmentIndex: Int): Color

    fun setPaletteColor(colorIndex: Int, color: Color)

    fun getPaletteColor(colorIndex: Int): Color

    fun addArrow(position: PolylinePosition, length: Float, fillColor: Color): Arrow

    val arrows: List<Arrow>

}