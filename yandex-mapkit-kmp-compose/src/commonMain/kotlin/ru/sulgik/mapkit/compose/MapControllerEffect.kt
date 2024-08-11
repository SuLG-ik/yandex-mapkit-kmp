package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import ru.sulgik.mapkit.map.MapWindow

@Composable
public fun MapControllerEffect(
    controller: YandexMapController,
    dispose: (MapWindow) -> Unit = {},
    block: (MapWindow) -> Unit,
) {
    val mapWindow = controller.mapWindow
    val currentBlock by rememberUpdatedState(block)
    val currentDispose by rememberUpdatedState(dispose)
    DisposableEffect(key1 = mapWindow) {
        if (mapWindow == null) {
            return@DisposableEffect onDispose { }
        }
        currentBlock(mapWindow)
        onDispose { currentDispose(mapWindow) }
    }
}

@Composable
public fun MapControllerEffect(
    controller: YandexMapController,
    key1: Any?,
    dispose: (MapWindow) -> Unit = {},
    block: (MapWindow) -> Unit,
) {
    val mapWindow = controller.mapWindow
    val currentBlock by rememberUpdatedState(block)
    val currentDispose by rememberUpdatedState(dispose)
    DisposableEffect(key1 = mapWindow, key2 = key1) {
        if (mapWindow == null) {
            return@DisposableEffect onDispose { }
        }
        currentBlock(mapWindow)
        onDispose { currentDispose(mapWindow) }
    }
}

@Composable
public fun MapControllerEffect(
    controller: YandexMapController,
    key1: Any?,
    key2: Any?,
    dispose: (MapWindow) -> Unit = {},
    block: (MapWindow) -> Unit,
) {
    val mapWindow = controller.mapWindow
    val currentBlock by rememberUpdatedState(block)
    val currentDispose by rememberUpdatedState(dispose)
    DisposableEffect(key1 = mapWindow, key2 = key1, key3 = key2) {
        if (mapWindow == null) {
            return@DisposableEffect onDispose { }
        }
        currentBlock(mapWindow)
        onDispose { currentDispose(mapWindow) }
    }
}

@Composable
public fun MapControllerEffect(
    controller: YandexMapController,
    key1: Any?,
    key2: Any?,
    key3: Any?,
    dispose: (MapWindow) -> Unit = {},
    block: (MapWindow) -> Unit,
) {
    val mapWindow = controller.mapWindow
    val currentBlock by rememberUpdatedState(block)
    val currentDispose by rememberUpdatedState(dispose)
    DisposableEffect(mapWindow, key1, key2, key3) {
        if (mapWindow == null) {
            return@DisposableEffect onDispose { }
        }
        currentBlock(mapWindow)
        onDispose { currentDispose(mapWindow) }
    }
}

@Composable
public fun MapControllerEffect(
    controller: YandexMapController,
    vararg keys: Any?,
    dispose: (MapWindow) -> Unit = {},
    block: (MapWindow) -> Unit,
) {
    val mapWindow = controller.mapWindow
    val currentBlock by rememberUpdatedState(block)
    val currentDispose by rememberUpdatedState(dispose)
    DisposableEffect(mapWindow, *keys) {
        if (mapWindow == null) {
            return@DisposableEffect onDispose { }
        }
        currentBlock(mapWindow)
        onDispose { currentDispose(mapWindow) }
    }
}
