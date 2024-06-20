package ru.sulgik.mapkit.compose

import YandexMapKit.YMKMapView as NativeMapView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import ru.sulgik.mapkit.mapview.MapWindow
import ru.sulgik.mapkit.mapview.toCommon

/**
 * Create and remember YandexMapController.
 * Don't pass to multiple YandexMap. Don't save it anywhere, contains native references.
 */
@Composable
actual fun rememberYandexMapController(): YandexMapController {
    return remember { YandexMapController(NativeMapView()) }
}

/**
 * Contains common implementation of MapWindow, that uses for controlling YandexMap
 */
actual class YandexMapController(
    internal val mapView: NativeMapView,
) {

    actual val mapWindow: MapWindow
        get() = mapView.mapWindow!!.toCommon()

}