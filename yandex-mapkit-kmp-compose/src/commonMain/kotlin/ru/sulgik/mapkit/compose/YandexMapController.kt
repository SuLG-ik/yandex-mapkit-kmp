package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import ru.sulgik.mapkit.compose.utils.LifecycleEffect
import ru.sulgik.mapkit.mapview.MapView

/**
 * Create and remember YandexMapController.
 * Don't pass to multiple YandexMap. Don't save it anywhere, contains native references.
 */
@Composable
fun rememberYandexMapController(): YandexMapController {
    return remember { YandexMapController() }
}

/**
 * Contains common implementation of MapWindow, that uses for controlling YandexMap
 */
class YandexMapController internal constructor() {

    internal val mapWindowOwner = MapWindowOwner()
    internal val mapView get() = mapWindowOwner.mapWindow

}

@Composable
internal fun MapView.bindToLifecycleOwner(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    LifecycleEffect(
        lifecycleOwner = lifecycleOwner,
        onStart = ::onStart,
        onStop = ::onStop,
        onDispose = ::onStop,
    )
}