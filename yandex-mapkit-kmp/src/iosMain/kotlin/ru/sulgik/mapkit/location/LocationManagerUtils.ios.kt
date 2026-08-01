package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationManagerUtils as NativeLocationManagerUtils

/**
 * Last known location, if one was ever received.
 */
public actual fun lastKnownLocation(): Location? {
    return NativeLocationManagerUtils.lastKnownLocation()?.toCommon()
}
