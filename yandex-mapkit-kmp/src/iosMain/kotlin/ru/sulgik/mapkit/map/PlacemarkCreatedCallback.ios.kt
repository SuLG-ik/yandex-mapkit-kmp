package ru.sulgik.mapkit.map

import YandexMapKit.YMKPlacemarkCreatedCallback as NativePlacemarkCreatedCallback
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

public actual abstract class PlacemarkCreatedCallback actual constructor() {

    private val nativeCallback = object : NativePlacemarkCreatedCallback {
        override fun invoke(p1: NativePlacemarkMapObject?) {
            if (p1 != null) {
                onPlacemarkCreated(p1.toCommon())
            }
        }
    }

    public fun toNative(): NativePlacemarkCreatedCallback {
        return nativeCallback
    }

    public actual abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)
}