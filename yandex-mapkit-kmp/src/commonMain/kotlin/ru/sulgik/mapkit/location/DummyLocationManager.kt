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

/**
 * Views the dummy manager as the [LocationManager] that MapKit derives it from.
 *
 * The returned manager drives the same underlying object, so
 * [LocationManager.subscribeForLocationUpdates] and [LocationManager.requestSingleUpdate] deliver
 * the locations pushed in with [DummyLocationManager.setLocation], and [LocationManager.suspend]
 * and [LocationManager.resume] control whether they reach the subscribers. The result can also be
 * handed to [ru.sulgik.mapkit.MapKit.setLocationManager] and [toLocationViewSource].
 */
public expect fun DummyLocationManager.asLocationManager(): LocationManager
