package ru.sulgik.mapkit

import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.MapKit as NativeMapKit

actual class MapKit(private val nativeMapKit: NativeMapKit) {

    fun toNative(): NativeMapKit {
        return nativeMapKit
    }

    actual companion object {
        actual fun setApiKey(apiKey: String) {
            MapKitFactory.setApiKey(apiKey)
        }

        actual fun getInstance(): MapKit {
            return MapKitFactory.getInstance().toCommon()
        }

        actual fun setLocale(locale: String?) {
            MapKitFactory.setLocale(locale)
        }

        actual fun setUserId(userId: String) {
            MapKitFactory.setUserId(userId)
        }
    }

    /**
     * Returns the version of the MapKit bundle.
     */
    actual val version: String
        get() = nativeMapKit.version

    /**
     * Resets the global location manager to a default one, that is a location manager that is created by createLocationManager() call.
     */
    actual fun resetLocationManagerToDefault() {
        nativeMapKit.resetLocationManagerToDefault()
    }

    /**
     * Notifies MapKit when the application resumes the foreground state.
     */
    actual fun onStart() {
        nativeMapKit.onStart()
    }

    /**
     * Notifies MapKit when the application pauses and goes to the background.
     */
    actual fun onStop() {
        nativeMapKit.onStop()
    }

}

fun NativeMapKit.toCommon(): MapKit {
    return MapKit(this)
}
