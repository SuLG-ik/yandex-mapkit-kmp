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

}