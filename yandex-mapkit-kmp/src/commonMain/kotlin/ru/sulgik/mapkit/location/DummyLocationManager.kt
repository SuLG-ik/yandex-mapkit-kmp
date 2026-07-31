package ru.sulgik.mapkit.location

/**
 * A location manager whose positions are pushed in by the application.
 */
public expect class DummyLocationManager {

    /**
     * Sets a location and notifies all consumers of this location.
     */
    public fun setLocation(location: Location, quality: DummyLocationQuality)
}
