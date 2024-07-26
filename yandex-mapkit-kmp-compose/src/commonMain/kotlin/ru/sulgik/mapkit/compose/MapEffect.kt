package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope
import ru.sulgik.mapkit.map.MapWindow

@Composable
public fun MapEffect(
    controller: YandexMapController,
    block: suspend CoroutineScope.(MapWindow) -> Unit,
) {
    val mapView = controller.mapView
    LaunchedEffect(key1 = mapView) {
        if (mapView == null) {
            return@LaunchedEffect
        }
        block(mapView.mapWindow)
    }
}

@Composable
public fun MapEffect(
    controller: YandexMapController,
    key1: Any?,
    block: suspend CoroutineScope.(MapWindow) -> Unit,
) {
    val mapView = controller.mapView
    LaunchedEffect(key1 = mapView, key2 = key1) {
        if (mapView == null) {
            return@LaunchedEffect
        }
        block(mapView.mapWindow)
    }
}

@Composable
public fun MapEffect(
    controller: YandexMapController,
    key1: Any?,
    key2: Any?,
    block: suspend CoroutineScope.(MapWindow) -> Unit,
) {
    val mapView = controller.mapView
    LaunchedEffect(key1 = mapView, key2 = key1, key3 = key2) {
        if (mapView == null) {
            return@LaunchedEffect
        }
        block(mapView.mapWindow)
    }
}

@Composable
public fun MapEffect(
    controller: YandexMapController,
    key1: Any?,
    key2: Any?,
    key3: Any?,
    block: suspend CoroutineScope.(MapWindow) -> Unit,
) {
    val mapView = controller.mapView
    LaunchedEffect(mapView, key1, key2, key3) {
        if (mapView == null) {
            return@LaunchedEffect
        }
        block(mapView.mapWindow)
    }
}

@Composable
public fun MapEffect(
    controller: YandexMapController,
    vararg keys: Any?,
    block: suspend CoroutineScope.(MapWindow) -> Unit,
) {
    val mapView = controller.mapView
    LaunchedEffect(mapView, *keys) {
        if (mapView == null) {
            return@LaunchedEffect
        }
        block(mapView.mapWindow)
    }
}
