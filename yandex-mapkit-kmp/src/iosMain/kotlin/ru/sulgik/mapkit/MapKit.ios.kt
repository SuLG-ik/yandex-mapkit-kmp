@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit

import YandexMapKit.setApiKey
import YandexMapKit.setLocale
import YandexMapKit.setUserId
import YandexMapKit.sharedInstance
import kotlinx.cinterop.ExperimentalForeignApi
import YandexMapKit.YMKMapKit as NativeMapKit

actual class MapKit internal constructor(private val nativeMapKit: NativeMapKit) {

    actual companion object {
        actual fun setApiKey(apiKey: String) {
            NativeMapKit.setApiKey(apiKey)
        }

        actual fun getInstance(): MapKit {
            return NativeMapKit.sharedInstance().toCommon()
        }

        actual fun setLocale(locale: String?) {
            NativeMapKit.setLocale(locale)
        }

        actual fun setUserId(userId: String) {
            NativeMapKit.setUserId(userId)
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