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

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PlacemarkPresentation) return false
        if (this::class != other::class) return false
        return nativePlacemarkPresentation == other.nativePlacemarkPresentation
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativePlacemarkPresentation.hashCode()
    }
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
