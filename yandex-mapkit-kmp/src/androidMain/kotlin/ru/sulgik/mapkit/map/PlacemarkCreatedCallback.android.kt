package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.PlacemarkCreatedCallback as NativePlacemarkCreatedCallback

public actual abstract class PlacemarkCreatedCallback actual constructor() {
    private val nativeCallback = NativePlacemarkCreatedCallback {
        onPlacemarkCreated(it.toCommon())
    }

    public fun toNative(): NativePlacemarkCreatedCallback {
        return nativeCallback
    }

    public actual abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)

}