package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

public actual class PlacemarkMapObject internal constructor(private val nativePlacemarkMapObject: NativePlacemarkMapObject) :
    MapObject(nativePlacemarkMapObject) {

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
        nativePlacemarkMapObject.setTextWithText(text, style.toNative())
    }

    public actual fun setTextStyle(style: TextStyle) {
        nativePlacemarkMapObject.setTextStyleWithStyle(style.toNative())
    }

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

}

public fun NativePlacemarkMapObject.toCommon(): PlacemarkMapObject {
    return PlacemarkMapObject(this)
}