package ru.sulgik.mapkit.location

expect abstract class LocationListener() {
    abstract fun onLocationUpdated(location: Location)
    abstract fun onLocationStatusUpdated(locationStatus: LocationStatus)
}

inline fun LocationListener(
    crossinline onLocationUpdated: (location: Location) -> Unit,
    crossinline onLocationStatusUpdated: (locationStatus: LocationStatus) -> Unit,
): LocationListener {
    return object : LocationListener() {
        override fun onLocationUpdated(location: Location) {
            onLocationUpdated.invoke(location)
        }

        override fun onLocationStatusUpdated(locationStatus: LocationStatus) {
            onLocationStatusUpdated.invoke(locationStatus)
        }
    }
}