package ru.sulgik.mapkit.map

import YandexMapKit.YMKPlacemarkMapObject
import platform.darwin.NSObject
import YandexMapKit.YMKPlacemarkCreatedCallback as NativePlacemarkCreatedCallback

actual class PlacemarkCreatedCallback actual constructor(
    private val onPlacemarkCreated: (placemark: PlacemarkMapObject) -> Unit,
) : NativePlacemarkCreatedCallback {

    override fun invoke(p1: YMKPlacemarkMapObject?) {
        if (p1 != null)
            onPlacemarkCreated(p1.toCommon())
    }

}