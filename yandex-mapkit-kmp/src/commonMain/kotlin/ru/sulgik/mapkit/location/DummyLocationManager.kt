package ru.sulgik.mapkit.location

/**
 * A location manager whose positions are pushed in by the application.
 */
public expect class DummyLocationManager {

    /**
     * Sets a location and notifies all consumers of this location.
     */
    public fun setLocation(location: Location, quality: DummyLocationQuality)

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
