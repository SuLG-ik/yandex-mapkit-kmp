package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.PlacemarkMapObject

@Composable
public expect fun imageProvider(content: @Composable () -> Unit): ImageProvider

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

@Composable
public expect fun clusterImageProvider(
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@Composable
public expect fun clusterImageProvider(
    key1: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@Composable
public expect fun clusterImageProvider(
    key1: Any?,
    key2: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@Composable
public expect fun clusterImageProvider(
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@Composable
public expect fun clusterImageProvider(
    vararg keys: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider


public expect fun PlacemarkMapObject.setContent(
    renderer: ComposeMapObjectRenderer,
    iconStyle: IconStyle = IconStyle(),
    content: @Composable () -> Unit,
)

@Composable
public expect fun rememberComposeMapObjectRenderer(): ComposeMapObjectRenderer

public expect interface ClusterImageProvider {
    public fun toImageProvider(cluster: Cluster): ImageProvider
}

public expect interface ComposeMapObjectRenderer