package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView

@Composable
internal actual fun NativeYandexMap(
    controller: YandexMapController,
    modifier: Modifier,
) {
    UIKitView(factory = { controller.mapView.toNative() }, modifier = modifier)
}