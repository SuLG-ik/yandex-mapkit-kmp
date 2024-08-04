package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.Job
import ru.sulgik.mapkit.compose.composition.MapUpdaterState
import ru.sulgik.mapkit.compose.composition.launchMapComposition
import ru.sulgik.mapkit.map.Map

@Composable
public fun YandexMap(
    controller: YandexMapController = rememberYandexMapController(),
    modifier: Modifier = Modifier,
) {
    NativeYandexMap(
        modifier = modifier,
        update = { controller.mapWindowOwner.setMapWindow(it.mapWindow) },
        onRelease = { controller.mapWindowOwner.setMapWindow(null) },
    )
}

@Composable
public fun YandexMap(
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    modifier: Modifier = Modifier,
    content: @[Composable YandexMapComposable] () -> Unit = {},
) {
    val mapUpdaterState = remember {
        MapUpdaterState(
            cameraPositionState = cameraPositionState,
        )
    }.also {
        it.cameraPositionState = cameraPositionState
    }

    val parentComposition = rememberCompositionContext()
    val currentContent by rememberUpdatedState(content)
    var subcompositionJob by remember { mutableStateOf<Job?>(null) }
    val parentCompositionScope = rememberCoroutineScope()

    NativeYandexMap(
        modifier = modifier,
        update = { mapView ->
            if (subcompositionJob == null) {
                subcompositionJob = parentCompositionScope.launchMapComposition(
                    parentComposition = parentComposition,
                    mapView = mapView,
                    mapUpdaterState = mapUpdaterState,
                    content = currentContent,
                )
            }
        }
    )
}

internal val LocalMap = compositionLocalOf<Map> { error("No Map instance provided") }