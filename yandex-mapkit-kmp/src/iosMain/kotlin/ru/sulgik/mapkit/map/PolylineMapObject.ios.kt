package ru.sulgik.mapkit.map

import YandexMapKit.YMKArrow
import platform.Foundation.NSNumber
import platform.Foundation.numberWithDouble
import platform.Foundation.numberWithInt
import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKPolylineMapObject as NativePolylineMapObject

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
        nativePolylineMapObject.selectWithSelectionColor(
            selectionColor.toNative(),
            subpolyline.toNative(),
        )
    }

    public actual fun hide(subpolyline: Subpolyline) {
        nativePolylineMapObject.hideWithSubpolyline(subpolyline.toNative())
    }

    public actual fun hide(subpolylines: List<Subpolyline>) {
        nativePolylineMapObject.hideWithSubpolylines(subpolylines.map { it.toNative() })
    }

    /**
     * Sets the polyline color.
     *
     * Effectively sets a single-color palette and sets all segments' palette indices to 0.
     */
    public actual fun setStrokeColor(color: Color) {
        return nativePolylineMapObject.setStrokeColorWithColor(color.toNative())
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
        nativePolylineMapObject.setStrokeColorsWithColors(
            paletteIndices.map { NSNumber.numberWithInt(it) },
            weights.map { NSNumber.numberWithDouble(it) },
        )
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
        nativePolylineMapObject.setStrokeColorsWithColors(
            paletteIndices.map { NSNumber.numberWithInt(it) },
        )
    }

    /**
     * Returns the palette index used by segment with the specified index.
     *
     * The returned value is an index into the palette, not a color; resolve it with
     * [getPaletteColor].
     */
    public actual fun getStrokeColor(segmentIndex: Int): Int {
        return nativePolylineMapObject.getStrokeColorWithSegmentIndex(segmentIndex.toULong())
            .toInt()
    }

    /**
     * Sets color in RGBA mode for [colorIndex].
     *
     * If the color is not provided for some index, the default value 0x0066FFFF is used.
     */
    public actual fun setPaletteColor(colorIndex: Int, color: Color) {
        return nativePolylineMapObject.setPaletteColorWithColorIndex(
            colorIndex.toULong(),
            color.toNative(),
        )
    }

    /**
     * Returns the palette color for the specified index.
     */
    public actual fun getPaletteColor(colorIndex: Int): Color {
        return nativePolylineMapObject.getPaletteColorWithColorIndex(colorIndex.toULong())
            .toCommon()
    }

    public actual fun addArrow(
        position: PolylinePosition,
        length: Float,
        fillColor: Color,
    ): Arrow {
        return nativePolylineMapObject.addArrowWithPosition(
            position.toNative(),
            length,
            fillColor.toNative(),
        ).toCommon()
    }

    public actual val arrows: List<Arrow>
        @Suppress("UNCHECKED_CAST")
        get() = (nativePolylineMapObject.arrows() as List<YMKArrow>).map { it.toCommon() }
}

public fun NativePolylineMapObject.toCommon(): PolylineMapObject {
    return PolylineMapObject(this)
}
