package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.LocationManagerUtils as NativeLocationManagerUtils

/**
 * Last known location, if one was ever received.
 */
public actual fun lastKnownLocation(): Location? {
    return NativeLocationManagerUtils.getLastKnownLocation()?.toCommon()
}
