package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
internal actual fun NativeYandexMap(
    controller: YandexMapController,
    modifier: Modifier,
) {
    AndroidView(factory = { controller.mapView.toNative() }, modifier = modifier)
}