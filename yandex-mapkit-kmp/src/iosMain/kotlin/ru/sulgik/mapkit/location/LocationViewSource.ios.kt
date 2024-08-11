package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationViewSource as NativeLocationViewSource
import YandexMapKit.YMKLocationViewSourceFactory.Companion as NativeLocationViewSourceFactory

public actual class LocationViewSource(private val nativeLocationViewSource: NativeLocationViewSource) {

    public fun toNative(): NativeLocationViewSource {
        return nativeLocationViewSource
    }

}

public fun NativeLocationViewSource.toCommon(): LocationViewSource {
    return LocationViewSource(this)
}

public actual fun LocationManager.toLocationViewSource(): LocationViewSource {
    return NativeLocationViewSourceFactory.createLocationViewSourceWithLocationManager(this.toNative())
        .toCommon()
}