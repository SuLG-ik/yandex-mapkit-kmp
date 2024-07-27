package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationViewSource as NativeLocationViewSource
import YandexMapKit.YMKLocationViewSourceFactory.Companion as NativeLocationViewSourceFactory

actual class LocationViewSource(private val nativeLocationViewSource: NativeLocationViewSource) {

    fun toNative(): NativeLocationViewSource {
        return nativeLocationViewSource
    }

}

fun NativeLocationViewSource.toCommon(): LocationViewSource {
    return LocationViewSource(this)
}

actual fun LocationManager.toLocationViewSource(): LocationViewSource {
    return NativeLocationViewSourceFactory.createLocationViewSourceWithLocationManager(this.toNative())
        .toCommon()
}