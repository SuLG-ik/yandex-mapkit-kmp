package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.GeoObject

/**
 * A tap on an object of the base map.
 */
public expect class GeoObjectTapEvent {

    /**
     * The object that was tapped.
     */
    public val geoObject: GeoObject

    /**
     * Tells if this **GeoObjectTapEvent** is valid or not.
     */
    public val isValid: Boolean
}
