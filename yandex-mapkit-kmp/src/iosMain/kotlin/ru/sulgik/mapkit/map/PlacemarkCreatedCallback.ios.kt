package ru.sulgik.mapkit.map

import YandexMapKit.YMKPlacemarkCreatedCallback as NativePlacemarkCreatedCallback
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

actual abstract class PlacemarkCreatedCallback actual constructor() {

    private val nativeCallback = object : NativePlacemarkCreatedCallback {
        override fun invoke(p1: NativePlacemarkMapObject?) {
            if (p1 != null) {
                onPlacemarkCreated(p1.toCommon())
            }
        }
    }

    fun toNative(): NativePlacemarkCreatedCallback {
        return nativeCallback
    }

    actual abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)
}