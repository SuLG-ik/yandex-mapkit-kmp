package ru.sulgik.mapkit.location

import kotlin.time.Duration

public expect class LocationManager {

    public fun subscribeForLocationUpdates(
        desiredAccuracy: Double,
        minTime: Duration,
        minDistance: Double,
        allowUseInBackground: Boolean,
        filteringMode: FilteringMode,
        purpose: LocationPurpose,
        locationListener: LocationListener,
    )

    public fun requestSingleUpdate(locationListener: LocationListener)

    public fun unsubscribe(locationListener: LocationListener)

    public fun suspend()

    public fun resume()

}