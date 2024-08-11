package ru.sulgik.mapkit.location

public expect abstract class LocationListener() {
    public abstract fun onLocationUpdated(location: Location)
    public abstract fun onLocationStatusUpdated(locationStatus: LocationStatus)
}

public inline fun LocationListener(
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