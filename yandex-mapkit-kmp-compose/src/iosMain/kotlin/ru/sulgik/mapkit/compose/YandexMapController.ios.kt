package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import ru.sulgik.mapkit.mapview.toCommon
import YandexMapKit.YMKMapView as NativeMapView

/**
 * Create and remember YandexMapController.
 * Don't pass to multiple YandexMap. Don't save it anywhere, contains native references.
 */
@Composable
actual fun rememberYandexMapController(): YandexMapController {
    return remember { YandexMapController(NativeMapView().toCommon()) }
}