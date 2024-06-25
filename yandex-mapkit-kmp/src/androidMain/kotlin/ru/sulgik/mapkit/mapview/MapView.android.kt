package ru.sulgik.mapkit.mapview

import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.map.toCommon
import com.yandex.mapkit.mapview.MapView as NativeMapView

actual class MapView(private val nativeMapView: NativeMapView) {

    fun toNative(): NativeMapView {
        return nativeMapView
    }

    actual fun onStart() {
        nativeMapView.onStart()
    }

    actual fun onStop() {
        nativeMapView.onStop()
    }

    actual val mapWindow: MapWindow = nativeMapView.mapWindow.toCommon()

}

fun NativeMapView.toCommon(): MapView {
    return MapView(this)
}