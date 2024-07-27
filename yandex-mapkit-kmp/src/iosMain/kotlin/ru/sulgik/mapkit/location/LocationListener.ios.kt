package ru.sulgik.mapkit.location

import platform.darwin.NSObject
import YandexMapKit.YMKLocation as NativeLocation
import YandexMapKit.YMKLocationDelegateProtocol as NativeLocationListener
import YandexMapKit.YMKLocationStatus as NativeLocationStatus

actual class LocationListener actual constructor(
    private val onLocationUpdated: (location: Location) -> Unit,
    private val onLocationStatusUpdated: (locationStatus: LocationStatus) -> Unit,
) : NativeLocationListener, NSObject() {

    override fun onLocationStatusUpdatedWithStatus(status: NativeLocationStatus) {
        onLocationStatusUpdated.invoke(status.toCommon())
    }

    override fun onLocationUpdatedWithLocation(location: NativeLocation) {
        onLocationUpdated.invoke(location.toCommon())
    }
}