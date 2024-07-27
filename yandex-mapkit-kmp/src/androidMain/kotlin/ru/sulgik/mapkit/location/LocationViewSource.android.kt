package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.LocationViewSource as NativeLocationViewSource
import com.yandex.mapkit.location.LocationViewSourceFactory as NativeLocationViewSourceFactory

actual class LocationViewSource(private val nativeLocationViewSource: NativeLocationViewSource) {

    fun toNative(): NativeLocationViewSource {
        return nativeLocationViewSource
    }

}

fun NativeLocationViewSource.toCommon(): LocationViewSource {
    return LocationViewSource(this)
}

actual fun LocationManager.toLocationViewSource(): LocationViewSource {
    return NativeLocationViewSourceFactory.createLocationViewSource(this.toNative()).toCommon()
}