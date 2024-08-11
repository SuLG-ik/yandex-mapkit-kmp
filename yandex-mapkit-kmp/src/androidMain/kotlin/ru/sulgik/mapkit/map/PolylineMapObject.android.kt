package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toColor
import ru.sulgik.mapkit.toArgb
import com.yandex.mapkit.map.Arrow as NativeArrow
import com.yandex.mapkit.map.PolylineMapObject as NativePolylineMapObject

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
        get() = nativePolylineMapObject.outlineColor.toColor()
        set(value) {
            nativePolylineMapObject.outlineColor = value.toArgb()
        }
    public actual var isInnerOutlineEnabled: Boolean
        get() = nativePolylineMapObject.isInnerOutlineEnabled
        set(value) {
            nativePolylineMapObject.isInnerOutlineEnabled = value
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
            nativePolylineMapObject.dashLength = value
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
        nativePolylineMapObject.select(selectionColor.toArgb(), subpolyline.toNative())
    }

    public actual fun hide(subpolyline: Subpolyline) {
        nativePolylineMapObject.hide(subpolyline.toNative())
    }

    public actual fun hide(subpolylines: List<Subpolyline>) {
        nativePolylineMapObject.hide(subpolylines.map { it.toNative() })
    }

    public actual fun setStrokeColors(
        colors: List<Color>,
        weights: List<Double>,
    ) {
        nativePolylineMapObject.setStrokeColors(colors.map(Color::toArgb), weights)
    }

    public actual fun setStrokeColors(colors: List<Color>) {
        nativePolylineMapObject.setStrokeColors(colors.map(Color::toArgb))
    }

    public actual fun setStrokeColor(color: Color) {
        return nativePolylineMapObject.setStrokeColor(color.toArgb())
    }

    public actual fun getStrokeColor(segmentIndex: Int): Color {
        return nativePolylineMapObject.getStrokeColor(segmentIndex).toColor()
    }

    public actual fun setPaletteColor(colorIndex: Int, color: Color) {
        return nativePolylineMapObject.setPaletteColor(colorIndex, color.toArgb())
    }

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