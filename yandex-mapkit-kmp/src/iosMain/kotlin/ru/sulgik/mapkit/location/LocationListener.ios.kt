package ru.sulgik.mapkit.location

import platform.darwin.NSObject
import YandexMapKit.YMKLocation as NativeLocation
import YandexMapKit.YMKLocationDelegateProtocol as NativeLocationListener
import YandexMapKit.YMKLocationStatus as NativeLocationStatus

public actual abstract class LocationListener actual constructor() {

    private val nativeListener  = object : NativeLocationListener, NSObject() {
        override fun onLocationStatusUpdatedWithStatus(status: NativeLocationStatus) {
            onLocationStatusUpdated(status.toCommon())
        }

        override fun onLocationUpdatedWithLocation(location: NativeLocation) {
            onLocationUpdated(location.toCommon())
        }
    }

    public fun toNative(): NativeLocationListener {
        return nativeListener
    }

    public actual abstract fun onLocationUpdated(location: Location)
    public actual abstract fun onLocationStatusUpdated(locationStatus: LocationStatus)
}