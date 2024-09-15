package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import ru.sulgik.mapkit.compose.utils.LifecycleEffect
import ru.sulgik.mapkit.map.MapWindow
import ru.sulgik.mapkit.mapview.MapView

/**
 * Create and remember YandexMapController.
 * Don't pass to multiple YandexMap. Don't save it anywhere, contains native references.
 */
@Composable
public fun rememberYandexMapController(): YandexMapController {
    return remember { YandexMapController() }
}

/**
 * Contains common implementation of MapWindow, that uses for controlling YandexMap
 */
public class YandexMapController internal constructor() {

    internal val mapWindowOwner = MapWindowOwner()
    public val mapWindow: MapWindow? get() = mapWindowOwner.mapWindow

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