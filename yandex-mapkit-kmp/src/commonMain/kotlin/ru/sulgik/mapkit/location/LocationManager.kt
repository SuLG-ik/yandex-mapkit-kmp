package ru.sulgik.mapkit.location

import ru.sulgik.mapkit.WeakRef

public expect class LocationManager {

    public fun subscribeForLocationUpdates(
        subscriptionSettings: SubscriptionSettings,
        locationListener: WeakRef<LocationListener>,
    )

    public fun requestSingleUpdate(locationListener: WeakRef<LocationListener>)

    public fun unsubscribe(locationListener: WeakRef<LocationListener>)

    public fun suspend()

    public fun resume()

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    override fun equals(other: Any?): Boolean

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    override fun hashCode(): Int
}
