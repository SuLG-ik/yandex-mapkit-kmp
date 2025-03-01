package ru.sulgik.mapkit.location

public expect class LocationManager {

    public fun subscribeForLocationUpdates(
        subscriptionSettings: SubscriptionSettings,
        locationListener: LocationListener,
    )

    public fun requestSingleUpdate(locationListener: LocationListener)

    public fun unsubscribe(locationListener: LocationListener)

    public fun suspend()

    public fun resume()

}