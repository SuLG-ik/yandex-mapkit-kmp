package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.PlacemarkMapObject

@Composable
public expect fun imageProvider(content: @Composable () -> Unit): ImageProvider

public expect fun PlacemarkMapObject.setContent(
    renderer: ComposeMapObjectRenderer,
    iconStyle: IconStyle = IconStyle(),
    content: @Composable () -> Unit,
)

@Composable
public expect fun rememberComposeMapObjectRenderer(): ComposeMapObjectRenderer

public expect interface ComposeMapObjectRenderer

@Composable
public expect fun imageProvider(
    key1: Any?,
    content: @Composable () -> Unit
): ImageProvider

@Composable
public expect fun imageProvider(
    key1: Any?,
    key2: Any?,
    content: @Composable () -> Unit
): ImageProvider

@Composable
public expect fun imageProvider(
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable () -> Unit
): ImageProvider

@Composable
public expect fun imageProvider(
    vararg keys: Any?,
    content: @Composable () -> Unit
): ImageProvider