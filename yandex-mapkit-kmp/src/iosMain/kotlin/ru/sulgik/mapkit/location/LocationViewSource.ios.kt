package ru.sulgik.mapkit.location

import YandexMapKit.YMKLocationViewSource as NativeLocationViewSource
import YandexMapKit.YMKLocationViewSourceFactory.Companion as NativeLocationViewSourceFactory

public actual class LocationViewSource(private val nativeLocationViewSource: NativeLocationViewSource) {

    public fun toNative(): NativeLocationViewSource {
        return nativeLocationViewSource
    }

    /**
     * Two handles are equal when they have the same type and wrap the same native object.
     */
    actual override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LocationViewSource) return false
        if (this::class != other::class) return false
        return nativeLocationViewSource == other.nativeLocationViewSource
    }

    /**
     * The hash code of the wrapped native object, consistent with [equals].
     */
    actual override fun hashCode(): Int {
        return nativeLocationViewSource.hashCode()
    }
}

public fun NativeLocationViewSource.toCommon(): LocationViewSource {
    return LocationViewSource(this)
}

public actual fun LocationManager.toLocationViewSource(): LocationViewSource {
    return NativeLocationViewSourceFactory.createLocationViewSourceWithLocationManager(this.toNative())
        .toCommon()
}
