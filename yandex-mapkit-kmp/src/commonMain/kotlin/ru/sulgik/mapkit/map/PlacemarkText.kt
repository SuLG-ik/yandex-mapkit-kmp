package ru.sulgik.mapkit.map

/**
 * Provides an interface to set text and its style for a placemark.
 */
public expect class PlacemarkText {

    /**
     * UTF-8 encoded text to be displayed with the [PlacemarkMapObject]. Empty string means no text.
     */
    public var text: String

    /**
     * The style properties (size, color, etc.) of the placemark text.
     */
    public var style: TextStyle

    /**
     * Tells if this **PlacemarkText** is valid or not.
     */
    public val isValid: Boolean
}
