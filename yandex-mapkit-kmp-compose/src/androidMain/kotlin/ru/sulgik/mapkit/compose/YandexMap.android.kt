package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import ru.sulgik.mapkit.mapview.toCommon
import com.yandex.mapkit.mapview.MapView as NativeMapView

@Composable
internal actual fun NativeYandexMap(
    controller: YandexMapController,
    modifier: Modifier,
) {
    val context = LocalContext.current
    val nativeMapView = remember { NativeMapView(context) }
    val mapView = remember(nativeMapView) { nativeMapView.toCommon() }
    mapView.bindToLifecycleOwner()
    AndroidView(
        factory = {
            controller.mapWindowOwner.setMapWindow(mapView)
            nativeMapView
        },
        onRelease = { mapView.onStop() },
        modifier = modifier,
    )
}