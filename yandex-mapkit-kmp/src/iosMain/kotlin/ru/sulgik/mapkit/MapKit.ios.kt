@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit

import YandexMapKit.setApiKey
import YandexMapKit.setLocale
import YandexMapKit.setUserId
import YandexMapKit.sharedInstance
import kotlinx.cinterop.ExperimentalForeignApi
import YandexMapKit.YMKMapKit as NativeMapKit

actual class MapKit(private val nativeMapKit: NativeMapKit) {

    actual companion object {
        actual fun setApiKey(apiKey: String) {
            NativeMapKit.setApiKey(apiKey)
        }

        actual fun getInstance(): MapKit {
            return NativeMapKit.sharedInstance().toNative()
        }

        actual fun setLocale(locale: String?) {
            NativeMapKit.setLocale(locale)
        }

        actual fun setUserId(userId: String) {
            NativeMapKit.setUserId(userId)
        }
    }

}

private fun NativeMapKit.toNative(): MapKit {
    return ru.sulgik.mapkit.MapKit(this)
}