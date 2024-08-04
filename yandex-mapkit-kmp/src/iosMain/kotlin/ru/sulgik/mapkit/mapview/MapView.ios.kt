package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.toCommon
import YandexMapKit.YMKMapView as NativeMapView

public actual class MapView internal constructor(private val nativeMapView: NativeMapView) {

    public fun toNative(): NativeMapView {
        return nativeMapView
    }

    public actual fun onStart() {

    }

    public actual fun onStop() {
    }

    public actual val mapWindow: MapWindow = nativeMapView.mapWindow!!.toCommon()

}

public fun NativeMapView.toCommon(): MapView {
    return MapView(this)
}