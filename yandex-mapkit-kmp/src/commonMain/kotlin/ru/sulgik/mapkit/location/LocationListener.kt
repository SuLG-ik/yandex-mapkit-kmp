package ru.sulgik.mapkit.location

expect class LocationListener(
    onLocationUpdated: (location: Location) -> Unit,
    onLocationStatusUpdated: (locationStatus: LocationStatus) -> Unit,
)