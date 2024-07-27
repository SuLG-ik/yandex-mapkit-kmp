package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.Location as NativeLocation
import com.yandex.mapkit.location.LocationListener as NativeLocationListener
import com.yandex.mapkit.location.LocationStatus as NativeLocationStatus

actual abstract class LocationListener actual constructor() {

    private val nativeListener = object : NativeLocationListener {
        override fun onLocationUpdated(p0: NativeLocation) {
            onLocationUpdated(p0.toCommon())
        }

        override fun onLocationStatusUpdated(p0: NativeLocationStatus) {
            onLocationStatusUpdated(p0.toCommon())
        }
    }

    fun toNative(): NativeLocationListener {
        return nativeListener
    }

    actual abstract fun onLocationUpdated(location: Location)
    actual abstract fun onLocationStatusUpdated(locationStatus: LocationStatus)
}