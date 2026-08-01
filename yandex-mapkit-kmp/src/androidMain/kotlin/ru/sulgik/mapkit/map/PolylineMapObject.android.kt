package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toArgb
import ru.sulgik.mapkit.toColor
import com.yandex.mapkit.map.Arrow as NativeArrow
import com.yandex.mapkit.map.PolylineMapObject as NativePolylineMapObject

public actual class PolylineMapObject internal constructor(private val nativePolylineMapObject: NativePolylineMapObject) : MapObject(nativePolylineMapObject) {

    override fun toNative(): NativePolylineMapObject {
        return nativePolylineMapObject
    }

    public actual var geometry: Polyline
        get() = nativePolylineMapObject.geometry.toCommon()
        set(value) {
            nativePolylineMapObject.geometry = value.toNative()
        }

    public actual var style: LineStyle
        get() = nativePolylineMapObject.style.toCommon()
        set(value) {
            nativePolylineMapObject.style = value.toNative()
        }

    public actual fun select(
        selectionColor: Color,
        subpolyline: Subpolyline,
    ) {
        nativePolylineMapObject.select(selectionColor.toArgb(), subpolyline.toNative())
    }

    public actual fun hide(subpolyline: Subpolyline) {
        nativePolylineMapObject.hide(subpolyline.toNative())
    }

    public actual fun hide(subpolylines: List<Subpolyline>) {
        nativePolylineMapObject.hide(subpolylines.map { it.toNative() })
    }

    /**
     * Sets the polyline color.
     *
     * Effectively sets a single-color palette and sets all segments' palette indices to 0.
     */
    public actual fun setStrokeColor(color: Color) {
        return nativePolylineMapObject.setStrokeColor(color.toArgb())
    }

    /**
     * Sets indexes of colors in palette for line segments.
     *
     * A polyline is colored through a palette: [setPaletteColor] defines the color stored under an
     * index, and this method assigns one of those indexes to every segment. By default, all segments
     * use palette index 0.
     *
     * [weights] are used for generalization of colors.
     */
    public actual fun setStrokeColors(
        paletteIndices: List<Int>,
        weights: List<Double>,
    ) {
        nativePolylineMapObject.setStrokeColors(paletteIndices, weights)
    }

    /**
     * Sets indexes of colors in palette for line segments.
     *
     * A polyline is colored through a palette: [setPaletteColor] defines the color stored under an
     * index, and this method assigns one of those indexes to every segment. By default, all segments
     * use palette index 0.
     *
     * All the weights are equal to 1.
     */
    public actual fun setStrokeColors(paletteIndices: List<Int>) {
        nativePolylineMapObject.setStrokeColors(paletteIndices)
    }

    /**
     * Returns the palette index used by segment with the specified index.
     *
     * The returned value is an index into the palette, not a color; resolve it with
     * [getPaletteColor].
     */
    public actual fun getStrokeColor(segmentIndex: Int): Int {
        return nativePolylineMapObject.getStrokeColor(segmentIndex)
    }

    /**
     * Sets color in RGBA mode for [colorIndex].
     *
     * If the color is not provided for some index, the default value 0x0066FFFF is used.
     */
    public actual fun setPaletteColor(colorIndex: Int, color: Color) {
        return nativePolylineMapObject.setPaletteColor(colorIndex, color.toArgb())
    }

    /**
     * Returns the palette color for the specified index.
     */
    public actual fun getPaletteColor(colorIndex: Int): Color {
        return nativePolylineMapObject.getPaletteColor(colorIndex).toColor()
    }

    public actual fun addArrow(
        position: PolylinePosition,
        length: Float,
        fillColor: Color,
    ): Arrow {
        return nativePolylineMapObject.addArrow(position.toNative(), length, fillColor.toArgb())
            .toCommon()
    }

    public actual val arrows: List<Arrow>
        get() = nativePolylineMapObject.arrows().map(NativeArrow::toCommon)
}

public fun NativePolylineMapObject.toCommon(): PolylineMapObject {
    return PolylineMapObject(this)
}
