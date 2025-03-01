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

    public actual var style: LineStyle
        get() = nativePolylineMapObject.style.toCommon()
        set(value) {
            nativePolylineMapObject.style = value.toNative()
        }

    @Deprecated("Use style.strokeWidth instead", ReplaceWith("style.strokeWidth"))
    @Suppress("DEPRECATION")
    public actual var strokeWidth: Float
        get() = nativePolylineMapObject.strokeWidth
        set(value) {
            nativePolylineMapObject.strokeWidth = value
        }

    @Deprecated("Use style.gradientLength instead", ReplaceWith("style.gradientLength"))
    @Suppress("DEPRECATION")
    public actual var gradientLength: Float
        get() = nativePolylineMapObject.gradientLength
        set(value) {
            nativePolylineMapObject.gradientLength = value
        }

    @Deprecated("Use style.outlineWidth instead", ReplaceWith("style.outlineWidth"))
    @Suppress("DEPRECATION")
    public actual var outlineWidth: Float
        get() = nativePolylineMapObject.outlineWidth
        set(value) {
            nativePolylineMapObject.outlineWidth = value
        }

    @Deprecated("Use style.outlineColor instead", ReplaceWith("style.outlineColor"))
    @Suppress("DEPRECATION")
    public actual var outlineColor: Color
        get() = nativePolylineMapObject.outlineColor.toColor()
        set(value) {
            nativePolylineMapObject.outlineColor = value.toArgb()
        }

    @Deprecated("Use style.innerOutlineEnabled instead", ReplaceWith("style.innerOutlineEnabled"))
    @Suppress("DEPRECATION")
    public actual var isInnerOutlineEnabled: Boolean
        get() = nativePolylineMapObject.isInnerOutlineEnabled
        set(value) {
            nativePolylineMapObject.isInnerOutlineEnabled = value
        }

    @Deprecated("Use style.turnRadius instead", ReplaceWith("style.turnRadius"))
    @Suppress("DEPRECATION")
    public actual var turnRadius: Float
        get() = nativePolylineMapObject.turnRadius
        set(value) {
            nativePolylineMapObject.turnRadius = value
        }

    @Deprecated("Use style.dashLength instead", ReplaceWith("style.dashLength"))
    @Suppress("DEPRECATION")
    public actual var dashLength: Float
        get() = nativePolylineMapObject.dashLength
        set(value) {
            nativePolylineMapObject.dashLength = value
        }

    @Deprecated("Use style.gapLength instead", ReplaceWith("style.gapLength"))
    @Suppress("DEPRECATION")
    public actual var gapLength: Float
        get() = nativePolylineMapObject.gapLength
        set(value) {
            nativePolylineMapObject.gapLength = value
        }

    @Deprecated("Use style.dashOffset instead", ReplaceWith("style.dashOffset"))
    @Suppress("DEPRECATION")
    public actual var dashOffset: Float
        get() = nativePolylineMapObject.dashOffset
        set(value) {
            nativePolylineMapObject.dashOffset = value
        }

    @Deprecated("Use style.arcApproximationStep instead", ReplaceWith("style.arcApproximationStep"))
    @Suppress("DEPRECATION")
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