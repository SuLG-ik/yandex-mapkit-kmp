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

actual class PolylineMapObject(private val nativePolylineMapObject: NativePolylineMapObject) :
    MapObject(nativePolylineMapObject) {

    override fun toNative(): NativePolylineMapObject {
        return nativePolylineMapObject
    }

    actual var geometry: Polyline
        get() = nativePolylineMapObject.geometry.toCommon()
        set(value) {
            nativePolylineMapObject.geometry = value.toNative()
        }
    actual var strokeWidth: Float
        get() = nativePolylineMapObject.strokeWidth
        set(value) {
            nativePolylineMapObject.strokeWidth = value
        }
    actual var gradientLength: Float
        get() = nativePolylineMapObject.gradientLength
        set(value) {
            nativePolylineMapObject.gradientLength = value
        }
    actual var outlineWidth: Float
        get() = nativePolylineMapObject.outlineWidth
        set(value) {
            nativePolylineMapObject.outlineWidth = value
        }
    actual var outlineColor: Color
        get() = nativePolylineMapObject.outlineColor.toCommon()
        set(value) {
            nativePolylineMapObject.outlineColor = value.toNative()
        }
    actual var isInnerOutlineEnabled: Boolean
        get() = nativePolylineMapObject.isInnerOutlineEnabled()
        set(value) {
            nativePolylineMapObject.setInnerOutlineEnabled(value)
        }

    actual var turnRadius: Float
        get() = nativePolylineMapObject.turnRadius
        set(value) {
            nativePolylineMapObject.turnRadius = value
        }
    actual var dashLength: Float
        get() = nativePolylineMapObject.dashLength
        set(value) {
            nativePolylineMapObject.dashLength = value
        }
    actual var gapLength: Float
        get() = nativePolylineMapObject.gapLength
        set(value) {
            nativePolylineMapObject.gapLength = value
        }
    actual var dashOffset: Float
        get() = nativePolylineMapObject.dashOffset
        set(value) {
            nativePolylineMapObject.dashOffset = value
        }

    actual fun select(
        selectionColor: Color,
        subpolyline: Subpolyline,
    ) {
        nativePolylineMapObject.selectWithSelectionColor(
            selectionColor.toNative(),
            subpolyline.toNative(),
        )
    }

    actual fun hide(subpolyline: Subpolyline) {
        nativePolylineMapObject.hideWithSubpolyline(subpolyline.toNative())
    }

    actual fun hide(subpolylines: List<Subpolyline>) {
        nativePolylineMapObject.hideWithSubpolylines(subpolylines.map { it.toNative() })
    }

    actual fun setStrokeColors(
        colors: List<Color>,
        weights: List<Double>,
    ) {
        nativePolylineMapObject.setStrokeColorsWithColors(
            colors.map { NSNumber.numberWithInt(it.value) },
            weights.map { NSNumber.numberWithDouble(it) },
        )
    }

    actual fun setStrokeColors(colors: List<Color>) {
        nativePolylineMapObject.setStrokeColorsWithColors(
            colors.map { NSNumber.numberWithInt(it.value) },
        )
    }

    actual fun getStrokeColor(segmentIndex: Int): Color {
        return Color(
            nativePolylineMapObject.getStrokeColorWithSegmentIndex(segmentIndex.toULong()).toInt()
        )
    }

    actual fun setPaletteColor(colorIndex: Int, color: Color) {
        return nativePolylineMapObject.setPaletteColorWithColorIndex(
            colorIndex.toULong(),
            color.toNative()
        )
    }

    actual fun getPaletteColor(colorIndex: Int): Color {
        return nativePolylineMapObject.getPaletteColorWithColorIndex(colorIndex.toULong())
            .toCommon()
    }

    actual fun addArrow(
        position: PolylinePosition,
        length: Float,
        fillColor: Color,
    ): Arrow {
        return nativePolylineMapObject.addArrowWithPosition(position.toNative(), length, fillColor.toNative()).toCommon()
    }

    actual val arrows: List<Arrow>
        get() = (nativePolylineMapObject.arrows() as List<YMKArrow>).map { it.toCommon() }

}

fun NativePolylineMapObject.toCommon(): PolylineMapObject {
    return PolylineMapObject(this)
}