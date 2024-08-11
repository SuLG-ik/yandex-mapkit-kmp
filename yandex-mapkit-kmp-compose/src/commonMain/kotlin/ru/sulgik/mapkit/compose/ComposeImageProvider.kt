package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.map.ImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun imageProvider(
    size: DpSize,
    content: @Composable () -> Unit
): ImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun imageProvider(
    size: DpSize,
    key1: Any?,
    content: @Composable () -> Unit
): ImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun imageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    content: @Composable () -> Unit
): ImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun imageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable () -> Unit
): ImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun imageProvider(
    size: DpSize,
    vararg keys: Any?,
    content: @Composable () -> Unit
): ImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun clusterImageProvider(
    size: DpSize,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun clusterImageProvider(
    size: DpSize,
    vararg keys: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public expect fun rememberComposeMapObjectRenderer(): ComposeMapObjectRenderer

@YandexMapsComposeExperimentalApi
public expect class ClusterImageProvider {

    @YandexMapsComposeExperimentalApi
    internal fun toImageProvider(cluster: Cluster): ImageProvider
}

@YandexMapsComposeExperimentalApi
public expect class ComposeMapObjectRenderer {
    internal fun toImageProvider(
        size: DpSize,
        content: @Composable () -> Unit
    ): ImageProvider
}