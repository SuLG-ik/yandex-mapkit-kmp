package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import ru.sulgik.mapkit.compose.utils.LifecycleEffect
import ru.sulgik.mapkit.mapview.MapView
import ru.sulgik.mapkit.mapview.toCommon
import com.yandex.mapkit.mapview.MapView as NativeMapView

@Composable
internal actual fun NativeYandexMap(
    modifier: Modifier,
    onRelease: (MapView) -> Unit,
    update: (MapView) -> Unit,
) {
    val context = LocalContext.current
    val nativeMapView = remember { NativeMapView(context) }
    val mapView = remember(nativeMapView) { nativeMapView.toCommon() }
    val lifecycle = remember(mapView) {
        object {
            private var started = false
            private var released = false

            fun start() {
                if (!started && !released) {
                    mapView.onStart()
                    started = true
                }
            }

            fun stop() {
                if (started) {
                    started = false
                    mapView.onStop()
                }
            }

            fun release() {
                if (released) return
                released = true
                stop()
                mapView.destroy()
            }
        }
    }
    LifecycleEffect(
        onStart = lifecycle::start,
        onStop = lifecycle::stop,
        onDispose = lifecycle::stop,
    )
    AndroidView(
        factory = { nativeMapView },
        onRelease = {
            onRelease(mapView)
            lifecycle.release()
        },
        update = {
            update(mapView)
        },
        modifier = modifier,
    )
}
