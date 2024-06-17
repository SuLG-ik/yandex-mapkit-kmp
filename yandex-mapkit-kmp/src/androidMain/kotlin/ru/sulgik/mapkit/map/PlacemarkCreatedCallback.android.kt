package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.PlacemarkCreatedCallback as NativePlacemarkCreatedCallback

actual abstract class PlacemarkCreatedCallback actual constructor() :
    NativePlacemarkCreatedCallback {
    actual abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)

    override fun onPlacemarkCreated(p0: com.yandex.mapkit.map.PlacemarkMapObject) {
        onPlacemarkCreated(p0.toCommon())
    }
}