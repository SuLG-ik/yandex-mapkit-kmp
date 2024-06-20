package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.PlacemarkCreatedCallback as NativePlacemarkCreatedCallback

actual class PlacemarkCreatedCallback actual constructor(private val onPlacemarkCreated: (placemark: PlacemarkMapObject) -> Unit) :
    NativePlacemarkCreatedCallback {

    override fun onPlacemarkCreated(p0: com.yandex.mapkit.map.PlacemarkMapObject) {
        onPlacemarkCreated(p0.toCommon())
    }

}