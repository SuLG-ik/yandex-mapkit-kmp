package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.PointF
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.map.PlacemarkMapObject as NativePlacemarkMapObject

public actual class PlacemarkMapObject internal constructor(private val nativePlacemarkMapObject: NativePlacemarkMapObject) : MapObject(nativePlacemarkMapObject) {

    override fun toNative(): NativePlacemarkMapObject {
        return nativePlacemarkMapObject
    }

    public actual var geometry: Point
        get() = nativePlacemarkMapObject.geometry.toCommon()
        set(value) {
            nativePlacemarkMapObject.geometry = value.toNative()
        }
    public actual var direction: Float
        get() = nativePlacemarkMapObject.direction
        set(value) {
            nativePlacemarkMapObject.direction = value
        }
    public actual var opacity: Float
        get() = nativePlacemarkMapObject.opacity
        set(value) {
            nativePlacemarkMapObject.opacity = value
        }

    public actual fun setText(text: String, style: TextStyle) {
        nativePlacemarkMapObject.setText(text, style.toNative())
    }

    public actual fun setTextStyle(style: TextStyle) {
        nativePlacemarkMapObject.setTextStyle(style.toNative())
    }

    public actual fun setIcon(
        image: ImageProvider,
        style: IconStyle,
        onFinished: Callback?,
    ) {
        if (onFinished != null) {
            nativePlacemarkMapObject.setIcon(
                image.toNative(),
                style.toNative(),
                onFinished.toNative(),
            )
        } else {
            nativePlacemarkMapObject.setIcon(image.toNative(), style.toNative())
        }
    }

    /**
     * Changes the icon style.
     */
    public actual fun setIconStyle(style: IconStyle) {
        nativePlacemarkMapObject.setIconStyle(style.toNative())
    }

    /**
     * Sets piecewise linear scale, depending on the zoom.
     */
    public actual fun setScaleFunction(points: List<PointF>) {
        nativePlacemarkMapObject.setScaleFunction(points.map { it.toNative() })
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
