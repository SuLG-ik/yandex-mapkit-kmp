package ru.sulgik.mapkit.map

import YandexMapKit.YMKPlacemarkCreatedCallback as NativePlacemarkCreatedCallback
import YandexMapKit.YMKPlacemarkMapObject as NativePlacemarkMapObject

public actual abstract class PlacemarkCreatedCallback actual constructor() {

    private val nativeCallback: (YandexMapKit.YMKPlacemarkMapObject?) -> Unit = {
        if (it != null) {
            onPlacemarkCreated(it.toCommon())
        }
    }

    public fun toNative(): NativePlacemarkCreatedCallback {
        return nativeCallback
    }

    public actual abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)
}