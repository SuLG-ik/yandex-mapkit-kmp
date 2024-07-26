package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import kotlinx.atomicfu.locks.reentrantLock
import kotlinx.atomicfu.locks.withLock
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

    private val lock = reentrantLock()
    internal var mapView: MapView? by mutableStateOf(null)

    internal fun setMapView(mapView: MapView?) {
        lock.withLock {
            if (this.mapView == null && mapView == null) return
            if (this.mapView == mapView) return
            if (this.mapView != null && mapView != null) {
                error("YandexMapController may only be associated with one MapView at a time")
            }
            this.mapView = mapView
        }
    }

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