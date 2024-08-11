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
import ru.sulgik.mapkit.toArgb
import ru.sulgik.mapkit.toColor
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKPolylineMapObject as NativePolylineMapObject

public actual class PolylineMapObject internal constructor(private val nativePolylineMapObject: NativePolylineMapObject) :
    MapObject(nativePolylineMapObject) {

    override fun toNative(): NativePolylineMapObject {
        return nativePolylineMapObject
    }

    public actual var geometry: Polyline
        get() = nativePolylineMapObject.geometry.toCommon()
        set(value) {
            nativePolylineMapObject.geometry = value.toNative()
        }
    public actual var strokeWidth: Float
        get() = nativePolylineMapObject.strokeWidth
        set(value) {
            nativePolylineMapObject.strokeWidth = value
        }
    public actual var gradientLength: Float
        get() = nativePolylineMapObject.gradientLength
        set(value) {
            nativePolylineMapObject.gradientLength = value
        }
    public actual var outlineWidth: Float
        get() = nativePolylineMapObject.outlineWidth
        set(value) {
            nativePolylineMapObject.outlineWidth = value
        }
    public actual var outlineColor: Color
        get() = nativePolylineMapObject.outlineColor.toCommon()
        set(value) {
            nativePolylineMapObject.outlineColor = value.toNative()
        }
    public actual var isInnerOutlineEnabled: Boolean
        get() = nativePolylineMapObject.isInnerOutlineEnabled()
        set(value) {
            nativePolylineMapObject.setInnerOutlineEnabled(value)
        }

    public actual var turnRadius: Float
        get() = nativePolylineMapObject.turnRadius
        set(value) {
            nativePolylineMapObject.turnRadius = value
        }
    public actual var dashLength: Float
        get() = nativePolylineMapObject.dashLength
        set(value) {
            nativePolylineMapObject.dashLength = value
        }
    public actual var gapLength: Float
        get() = nativePolylineMapObject.gapLength
        set(value) {
            nativePolylineMapObject.gapLength = value
        }
    public actual var dashOffset: Float
        get() = nativePolylineMapObject.dashOffset
        set(value) {
            nativePolylineMapObject.dashOffset = value
        }

    public actual var arcApproximationStep: Float
        get() = nativePolylineMapObject.arcApproximationStep
        set(value) {
            nativePolylineMapObject.arcApproximationStep = value
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

    public actual fun setStrokeColors(
        colors: List<Color>,
        weights: List<Double>,
    ) {
        nativePolylineMapObject.setStrokeColorsWithColors(
            colors.map { NSNumber.numberWithInt(it.toArgb()) },
            weights.map { NSNumber.numberWithDouble(it) },
        )
    }

    public actual fun setStrokeColors(colors: List<Color>) {
        nativePolylineMapObject.setStrokeColorsWithColors(
            colors.map { NSNumber.numberWithInt(it.toArgb()) },
        )
    }

    public actual fun getStrokeColor(segmentIndex: Int): Color {
        return nativePolylineMapObject.getStrokeColorWithSegmentIndex(segmentIndex.toULong())
            .toInt().toColor()
    }

    public actual fun setStrokeColor(color: Color) {
        return nativePolylineMapObject.setStrokeColorWithColor(color.toNative())
    }

    public actual fun setPaletteColor(colorIndex: Int, color: Color) {
        return nativePolylineMapObject.setPaletteColorWithColorIndex(
            colorIndex.toULong(),
            color.toNative()
        )
    }

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
            fillColor.toNative()
        ).toCommon()
    }

    public actual val arrows: List<Arrow>
        @Suppress("UNCHECKED_CAST")
        get() = (nativePolylineMapObject.arrows() as List<YMKArrow>).map { it.toCommon() }

}

public fun NativePolylineMapObject.toCommon(): PolylineMapObject {
    return PolylineMapObject(this)
}