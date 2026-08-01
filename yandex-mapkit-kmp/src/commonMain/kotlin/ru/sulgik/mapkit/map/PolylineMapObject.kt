package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline

public expect class PolylineMapObject : MapObject {

    public var geometry: Polyline

    public var style: LineStyle

    public fun select(selectionColor: Color, subpolyline: Subpolyline)

    public fun hide(subpolyline: Subpolyline)

    public fun hide(subpolylines: List<Subpolyline>)

    /**
     * Sets the polyline color.
     *
     * Effectively sets a single-color palette and sets all segments' palette indices to 0.
     */
    public fun setStrokeColor(color: Color)

    /**
     * Sets indexes of colors in palette for line segments.
     *
     * A polyline is colored through a palette: [setPaletteColor] defines the color stored under an
     * index, and this method assigns one of those indexes to every segment. By default, all segments
     * use palette index 0.
     *
     * [weights] are used for generalization of colors.
     */
    public fun setStrokeColors(paletteIndices: List<Int>, weights: List<Double>)

    /**
     * Sets indexes of colors in palette for line segments.
     *
     * A polyline is colored through a palette: [setPaletteColor] defines the color stored under an
     * index, and this method assigns one of those indexes to every segment. By default, all segments
     * use palette index 0.
     *
     * All the weights are equal to 1.
     */
    public fun setStrokeColors(paletteIndices: List<Int>)

    /**
     * Returns the palette index used by segment with the specified index.
     *
     * The returned value is an index into the palette, not a color; resolve it with
     * [getPaletteColor].
     */
    public fun getStrokeColor(segmentIndex: Int): Int

    /**
     * Sets color in RGBA mode for [colorIndex].
     *
     * If the color is not provided for some index, the default value 0x0066FFFF is used.
     */
    public fun setPaletteColor(colorIndex: Int, color: Color)

    /**
     * Returns the palette color for the specified index.
     */
    public fun getPaletteColor(colorIndex: Int): Color

    public fun addArrow(position: PolylinePosition, length: Float, fillColor: Color): Arrow

    public val arrows: List<Arrow>
}
