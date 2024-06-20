package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView

@Composable
actual fun YandexMap(
    controller: YandexMapController,
    modifier: Modifier,
) {
    UIKitView(factory = { controller.mapView }, modifier = modifier)
}