package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.Color
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.PolylinePosition
import ru.sulgik.mapkit.geometry.Subpolyline
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.map.Arrow as NativeArrow
import com.yandex.mapkit.map.PolylineMapObject as NativePolylineMapObject

actual class PolylineMapObject internal constructor(private val nativePolylineMapObject: NativePolylineMapObject) :
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
        get() = nativePolylineMapObject.outlineColor.let(::Color)
        set(value) {
            nativePolylineMapObject.outlineColor = value.value
        }
    actual var isInnerOutlineEnabled: Boolean
        get() = nativePolylineMapObject.isInnerOutlineEnabled
        set(value) {
            nativePolylineMapObject.isInnerOutlineEnabled = value
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
            nativePolylineMapObject.dashLength = value
        }

    actual fun select(
        selectionColor: Color,
        subpolyline: Subpolyline,
    ) {
        nativePolylineMapObject.select(selectionColor.value, subpolyline.toNative())
    }

    actual fun hide(subpolyline: Subpolyline) {
        nativePolylineMapObject.hide(subpolyline.toNative())
    }

    actual fun hide(subpolylines: List<Subpolyline>) {
        nativePolylineMapObject.hide(subpolylines.map { it.toNative() })
    }

    actual fun setStrokeColors(
        colors: List<Color>,
        weights: List<Double>,
    ) {
        nativePolylineMapObject.setStrokeColors(colors.map(Color::value), weights)
    }

    actual fun setStrokeColors(colors: List<Color>) {
        nativePolylineMapObject.setStrokeColors(colors.map(Color::value))
    }

    actual fun getStrokeColor(segmentIndex: Int): Color {
        return nativePolylineMapObject.getStrokeColor(segmentIndex).let(::Color)
    }

    actual fun setPaletteColor(colorIndex: Int, color: Color) {
        return nativePolylineMapObject.setPaletteColor(colorIndex, color.value)
    }

    actual fun getPaletteColor(colorIndex: Int): Color {
        return nativePolylineMapObject.getPaletteColor(colorIndex).let(::Color)
    }

    actual fun addArrow(
        position: PolylinePosition,
        length: Float,
        fillColor: Color,
    ): Arrow {
        return nativePolylineMapObject.addArrow(position.toNative(), length, fillColor.value)
            .toCommon()
    }

    actual val arrows: List<Arrow>
        get() = nativePolylineMapObject.arrows().map(NativeArrow::toCommon)

}

fun NativePolylineMapObject.toCommon(): PolylineMapObject {
    return PolylineMapObject(this)
}