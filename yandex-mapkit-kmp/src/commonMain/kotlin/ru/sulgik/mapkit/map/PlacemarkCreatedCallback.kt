package ru.sulgik.mapkit.map

expect abstract class PlacemarkCreatedCallback() {
    abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)
}

inline fun PlacemarkCreatedCallback(
    crossinline onPlacemarkCreated: (placemark: PlacemarkMapObject) -> Unit
): PlacemarkCreatedCallback {
    return object : PlacemarkCreatedCallback() {
        override fun onPlacemarkCreated(placemark: PlacemarkMapObject) {
            onPlacemarkCreated.invoke(placemark)
        }
    }
}