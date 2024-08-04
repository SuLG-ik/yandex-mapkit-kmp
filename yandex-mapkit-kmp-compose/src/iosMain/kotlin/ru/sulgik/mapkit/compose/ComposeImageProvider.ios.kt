package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.PlacemarkMapObject

@Composable
public actual fun imageProvider(content: @Composable () -> Unit): ImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun rememberComposeMapObjectRenderer(): ComposeMapObjectRenderer {
    TODO("Not yet implemented")
}

public actual fun PlacemarkMapObject.setContent(
    renderer: ComposeMapObjectRenderer,
    iconStyle: IconStyle,
    content: @Composable () -> Unit
) {

}

public actual interface ComposeMapObjectRenderer

@Composable
public actual fun imageProvider(
    key1: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun imageProvider(
    key1: Any?,
    key2: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun imageProvider(
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun imageProvider(
    vararg keys: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun clusterImageProvider(content: @Composable (Cluster) -> Unit): ClusterImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun clusterImageProvider(
    key1: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun clusterImageProvider(
    key1: Any?,
    key2: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun clusterImageProvider(
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    TODO("Not yet implemented")
}

@Composable
public actual fun clusterImageProvider(
    vararg keys: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    TODO("Not yet implemented")
}

public actual interface ClusterImageProvider {
    public actual fun toImageProvider(cluster: Cluster): ImageProvider
}