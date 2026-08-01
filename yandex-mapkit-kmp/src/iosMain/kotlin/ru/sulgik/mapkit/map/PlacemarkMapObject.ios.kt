package ru.sulgik.mapkit.map

import platform.Foundation.NSValue
import platform.UIKit.valueWithCGPoint
import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toNative
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

public actual class PlacemarkMapObject internal constructor(private val nativePlacemarkMapObject: NativePlacemarkMapObject) : MapObject(nativePlacemarkMapObject) {

    override fun toNative(): NativePlacemarkMapObject {
        return nativePlacemarkMapObject
    }

    public actual var geometry: Point
        get() = nativePlacemarkMapObject.geometry.toCommon()
        set(value) {
            nativePlacemarkMapObject.geometry = value.toNative()
        }

    /**
     * Angle between the direction of an object and the direction to north.
     */
    public actual var direction: Float
        get() = nativePlacemarkMapObject.direction
        set(value) {
            nativePlacemarkMapObject.direction = value
        }

    /**
     * Opacity multiplicator for the placemark content.
     */
    public actual var opacity: Float
        get() = nativePlacemarkMapObject.opacity
        set(value) {
            nativePlacemarkMapObject.opacity = value
        }

    /**
     * Sets the text with the given style for the placemark.
     */
    public actual fun setText(text: String, style: TextStyle) {
        nativePlacemarkMapObject.setTextWithText(text, style.toNative())
    }

    /**
     * Changes the text style.
     */
    public actual fun setTextStyle(style: TextStyle) {
        nativePlacemarkMapObject.setTextStyleWithStyle(style.toNative())
    }

    /**
     * Sets an icon with the given style for the placemark.
     */
    public actual fun setIcon(
        image: ImageProvider,
        style: IconStyle,
        onFinished: Callback?,
    ) {
        nativePlacemarkMapObject.setIconWithImage(
            image.toNative(),
            style.toNative(),
            onFinished?.toNative(),
        )
    }

    /**
     * Changes the icon style.
     */
    public actual fun setIconStyle(style: IconStyle) {
        nativePlacemarkMapObject.setIconStyleWithStyle(style.toNative())
    }

    /**
     * Sets piecewise linear scale, depending on the zoom.
     */
    public actual fun setScaleFunction(points: List<PointF>) {
        nativePlacemarkMapObject.setScaleFunctionWithPoints(
            points.map { NSValue.valueWithCGPoint(it.toNative()) },
        )
    }

    /**
     * Returns [Icon] object that can be used to set image and its style for the placemark.
     */
    public actual fun useIcon(): Icon {
        return nativePlacemarkMapObject.useIcon().toCommon()
    }

    /**
     * Returns [CompositeIcon] object that can be used to set icons and their styles for the
     * placemark.
     */
    public actual fun useCompositeIcon(): CompositeIcon {
        return nativePlacemarkMapObject.useCompositeIcon().toCommon()
    }

    /**
     * Returns [Model] object that can be used to set model and its style for the placemark.
     */
    public actual fun useModel(): Model {
        return nativePlacemarkMapObject.useModel().toCommon()
    }

    /**
     * Returns [PlacemarkAnimation] object that can be used to control animation of the placemark.
     */
    public actual fun useAnimation(): PlacemarkAnimation {
        return nativePlacemarkMapObject.useAnimation().toCommon()
    }

    /**
     * [PlacemarkText] can be used to set text and its style for the placemark.
     */
    public actual val text: PlacemarkText
        get() = nativePlacemarkMapObject.text.toCommon()
}

public fun NativePlacemarkMapObject.toCommon(): PlacemarkMapObject {
    return PlacemarkMapObject(this)
}
