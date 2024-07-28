package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.PlacemarkCreatedCallback as NativePlacemarkCreatedCallback

actual abstract class PlacemarkCreatedCallback actual constructor() {
    private val nativeCallback = NativePlacemarkCreatedCallback {
        onPlacemarkCreated(it.toCommon())
    }

    fun toNative(): NativePlacemarkCreatedCallback {
        return nativeCallback
    }

    actual abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)

}