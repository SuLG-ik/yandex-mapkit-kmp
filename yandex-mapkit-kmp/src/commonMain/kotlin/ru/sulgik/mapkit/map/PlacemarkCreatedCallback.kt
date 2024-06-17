package ru.sulgik.mapkit.map

expect abstract class PlacemarkCreatedCallback() {

    abstract fun onPlacemarkCreated(placemark: PlacemarkMapObject)

}


private class LambdaPlacemarkCreatedCallback(val onPlacemarkCreated: (placemark: PlacemarkMapObject) -> Unit) :
    PlacemarkCreatedCallback() {
    override fun onPlacemarkCreated(placemark: PlacemarkMapObject) {
        onPlacemarkCreated.invoke(placemark)
    }
}

fun PlacemarkCreatedCallback(onPlacemarkCreated: (placemark: PlacemarkMapObject) -> Unit): PlacemarkCreatedCallback {
    return LambdaPlacemarkCreatedCallback(onPlacemarkCreated)
}