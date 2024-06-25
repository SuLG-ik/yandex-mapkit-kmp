package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import ru.sulgik.mapkit.compose.utils.LifecycleEffect
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.mapview.MapView

/**
 * Create and remember YandexMapController.
 * Don't pass to multiple YandexMap. Don't save it anywhere, contains native references.
 */
@Composable
expect fun rememberYandexMapController(): YandexMapController

/**
 * Contains common implementation of MapWindow, that uses for controlling YandexMap
 */
class YandexMapController internal constructor(val mapView: MapView) {

    val mapWindow: MapWindow = mapView.mapWindow

}

@Composable
fun YandexMapController.bindToLifecycleOwner(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    LifecycleEffect(
        lifecycleOwner = lifecycleOwner,
        onStart = mapView::onStart,
        onStop = mapView::onStop,
        onDispose = mapView::onStop,
    )
}

@Composable
fun YandexMapController.bindToComposition() {
    DisposableEffect(this) {
        mapView.onStart()
        onDispose(mapView::onStop)
    }
}