package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.Location as NativeLocation
import com.yandex.mapkit.location.LocationListener as NativeLocationListener
import com.yandex.mapkit.location.LocationStatus as NativeLocationStatus

actual class LocationListener actual constructor(
    private val onLocationUpdated: (location: Location) -> Unit,
    private val onLocationStatusUpdated: (locationStatus: LocationStatus) -> Unit,
) : NativeLocationListener {

    override fun onLocationUpdated(p0: NativeLocation) {
        onLocationUpdated.invoke(p0.toCommon())
    }

    override fun onLocationStatusUpdated(p0: NativeLocationStatus) {
        onLocationStatusUpdated.invoke(p0.toCommon())
    }

}