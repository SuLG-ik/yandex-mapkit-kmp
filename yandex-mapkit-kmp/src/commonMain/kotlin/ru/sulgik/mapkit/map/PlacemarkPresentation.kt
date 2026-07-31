package ru.sulgik.mapkit.map

/**
 * A general interface for placemark presentation objects.
 */
public expect open class PlacemarkPresentation {

    /**
     * Removes the presentation.
     */
    public fun remove()

    /**
     * Tells if this **PlacemarkPresentation** is valid or not.
     */
    public val isValid: Boolean
}
