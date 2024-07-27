package ru.sulgik.mapkit.location

import kotlin.time.Duration

expect class LocationManager {

    fun subscribeForLocationUpdates(
        desiredAccuracy: Double,
        minTime: Duration,
        minDistance: Double,
        allowUseInBackground: Boolean,
        filteringMode: FilteringMode,
        locationListener: LocationListener,
    )

    fun requestSingleUpdate(locationListener: LocationListener)

    fun unsubscribe(locationListener: LocationListener)

    fun suspend()

    fun resume()

}