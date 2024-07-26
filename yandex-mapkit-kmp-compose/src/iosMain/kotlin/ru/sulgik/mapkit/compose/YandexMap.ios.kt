package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import ru.sulgik.mapkit.mapview.toCommon
import YandexMapKit.YMKMapView as NativeMapView

@Composable
internal actual fun NativeYandexMap(
    controller: YandexMapController,
    modifier: Modifier,
) {
    val nativeMapView = remember { NativeMapView() }
    val mapView = remember(nativeMapView) { nativeMapView.toCommon() }
    mapView.bindToLifecycleOwner()
    UIKitView(factory = {
        controller.setMapView(mapView)
        nativeMapView
    }, modifier = modifier)
}