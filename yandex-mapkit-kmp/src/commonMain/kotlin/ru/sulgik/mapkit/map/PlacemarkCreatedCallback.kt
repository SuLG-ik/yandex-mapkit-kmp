package ru.sulgik.mapkit.map

public expect abstract class PlacemarkCreatedCallback() {
    public abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)
}

public inline fun PlacemarkCreatedCallback(
    crossinline onPlacemarkCreated: (placemark: PlacemarkMapObject) -> Unit
): PlacemarkCreatedCallback {
    return object : PlacemarkCreatedCallback() {
        override fun onPlacemarkCreated(placemark: PlacemarkMapObject) {
            onPlacemarkCreated.invoke(placemark)
        }
    }
}