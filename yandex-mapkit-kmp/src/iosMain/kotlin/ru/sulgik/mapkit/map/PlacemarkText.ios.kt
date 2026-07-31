package ru.sulgik.mapkit.map

import YandexMapKit.YMKPlacemarkText as NativePlacemarkText

/**
 * Provides an interface to set text and its style for a placemark.
 */
public actual class PlacemarkText internal constructor(
    private val nativePlacemarkText: NativePlacemarkText,
) {

    public fun toNative(): NativePlacemarkText {
        return nativePlacemarkText
    }

    /**
     * UTF-8 encoded text to be displayed with the [PlacemarkMapObject]. Empty string means no text.
     */
    public actual var text: String
        get() = nativePlacemarkText.text
        set(value) {
            nativePlacemarkText.text = value
        }

    /**
     * The style properties (size, color, etc.) of the placemark text.
     */
    public actual var style: TextStyle
        get() = nativePlacemarkText.style.toCommon()
        set(value) {
            nativePlacemarkText.style = value.toNative()
        }

    /**
     * Tells if this **PlacemarkText** is valid or not.
     */
    public actual val isValid: Boolean
        get() = nativePlacemarkText.isValid()
}

public fun NativePlacemarkText.toCommon(): PlacemarkText {
    return PlacemarkText(this)
}
