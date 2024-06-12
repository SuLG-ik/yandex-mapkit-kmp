package ru.sulgik.mapkit

import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.MapKit as NativeMapKit

actual class MapKit(private val nativeMapKit: NativeMapKit) {
    actual companion object {
        actual fun setApiKey(apiKey: String) {
            MapKitFactory.setApiKey(apiKey)
        }

        actual fun getInstance(): MapKit {
            return MapKitFactory.getInstance().toNative()
        }

        actual fun setLocale(locale: String?) {
            MapKitFactory.setLocale(locale)
        }

        actual fun setUserId(userId: String) {
            MapKitFactory.setUserId(userId)
        }
    }

}

private fun NativeMapKit.toNative(): MapKit {
    return ru.sulgik.mapkit.MapKit(this)
}
