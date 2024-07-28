package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import com.yandex.mapkit.map.PlacemarkMapObject as NativePlacemarkMapObject

actual class PlacemarkMapObject internal constructor(private val nativePlacemarkMapObject: NativePlacemarkMapObject) :
    MapObject(nativePlacemarkMapObject) {

    override fun toNative(): NativePlacemarkMapObject {
        return nativePlacemarkMapObject
    }

    actual var geometry: Point
        get() = nativePlacemarkMapObject.geometry.toCommon()
        set(value) {
            nativePlacemarkMapObject.geometry = value.toNative()
        }
    actual var direction: Float
        get() = nativePlacemarkMapObject.direction
        set(value) {
            nativePlacemarkMapObject.direction = value
        }
    actual var opacity: Float
        get() = nativePlacemarkMapObject.opacity
        set(value) {
            nativePlacemarkMapObject.opacity = value
        }

    actual fun setText(text: String, style: TextStyle) {
        nativePlacemarkMapObject.setText(text, style.toNative())
    }

    actual fun setTextStyle(style: TextStyle) {
        nativePlacemarkMapObject.setTextStyle(style.toNative())
    }

    actual fun setIcon(
        image: ImageProvider,
        style: IconStyle,
        onFinished: Callback?,
    ) {
        if (onFinished != null) nativePlacemarkMapObject.setIcon(
            image.toNative(),
            style.toNative(),
            onFinished.toNative(),
        )
        else nativePlacemarkMapObject.setIcon(image.toNative(), style.toNative())
    }

}

fun NativePlacemarkMapObject.toCommon(): PlacemarkMapObject {
    return PlacemarkMapObject(this)
}