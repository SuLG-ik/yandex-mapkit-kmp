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

@Composable
fun YandexMap(
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    modifier: Modifier = Modifier,
) {
    val controller = rememberYandexMapController()
    MapEffect(controller) {
        cameraPositionState.mapWindowOwner.setMapWindow(it)
    }
    YandexMap(
        controller = controller,
        modifier = modifier,
    )
}