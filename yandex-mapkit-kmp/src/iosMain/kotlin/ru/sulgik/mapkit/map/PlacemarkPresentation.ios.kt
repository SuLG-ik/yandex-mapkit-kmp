package ru.sulgik.mapkit.map

import YandexMapKit.YMKCompositeIcon as NativeCompositeIcon
import YandexMapKit.YMKIcon as NativeIcon
import YandexMapKit.YMKModel as NativeModel
import YandexMapKit.YMKPlacemarkAnimation as NativePlacemarkAnimation
import YandexMapKit.YMKPlacemarkPresentation as NativePlacemarkPresentation

/**
 * A general interface for placemark presentation objects.
 */
public actual open class PlacemarkPresentation internal constructor(
    private val nativePlacemarkPresentation: NativePlacemarkPresentation,
) {

    public open fun toNative(): NativePlacemarkPresentation {
        return nativePlacemarkPresentation
    }

    /**
     * Removes the presentation.
     */
    public actual fun remove() {
        nativePlacemarkPresentation.remove()
    }

    /**
     * Tells if this **PlacemarkPresentation** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativePlacemarkPresentation.isValid()
}

public fun NativePlacemarkPresentation.toCommon(): PlacemarkPresentation {
    return when (this) {
        is NativeIcon -> toCommon()
        is NativeCompositeIcon -> toCommon()
        is NativeModel -> toCommon()
        is NativePlacemarkAnimation -> toCommon()
        else -> PlacemarkPresentation(this)
    }
}
