package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.LocationViewSource as NativeLocationViewSource
import com.yandex.mapkit.location.LocationViewSourceFactory as NativeLocationViewSourceFactory

public actual class LocationViewSource(private val nativeLocationViewSource: NativeLocationViewSource) {

    public fun toNative(): NativeLocationViewSource {
        return nativeLocationViewSource
    }

}

public fun NativeLocationViewSource.toCommon(): LocationViewSource {
    return LocationViewSource(this)
}

public actual fun LocationManager.toLocationViewSource(): LocationViewSource {
    return NativeLocationViewSourceFactory.createLocationViewSource(this.toNative()).toCommon()
}