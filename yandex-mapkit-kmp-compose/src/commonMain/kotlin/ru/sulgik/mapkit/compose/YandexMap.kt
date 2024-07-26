package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun YandexMap(
    controller: YandexMapController = rememberYandexMapController(),
    modifier: Modifier = Modifier,
) {
    NativeYandexMap(controller, modifier)
}