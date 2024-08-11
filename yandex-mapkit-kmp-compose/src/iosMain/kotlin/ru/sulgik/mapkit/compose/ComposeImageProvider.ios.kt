package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.renderComposeScene
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpSize
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.map.ImageProvider

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    content: @Composable () -> Unit
): ImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content) { renderer.toImageProvider(size, content) }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun rememberComposeMapObjectRenderer(): ComposeMapObjectRenderer {
    val density = LocalDensity.current
    return remember { ComposeMapObjectRenderer(density) }
}

public actual class ComposeMapObjectRenderer(
    private val density: Density,
) {

    /**
     * Highly experimental API. Will be changed in the future release
     * @param size use to render image on ios, ignored on android
     * @param content composable rendered to bitmap. Don't use animations or dynamic content.
     * Can be rendered only if key changed or parent render
     */
    internal actual fun toImageProvider(
        size: DpSize,
        content: @Composable () -> Unit
    ): ImageProvider {
        return renderComposeScene(
            width = with(density) { size.width.roundToPx() },
            height = with(density) { size.height.roundToPx() },
            density = density,
            content = content
        ).toComposeImageBitmap().toImageProvider()
    }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    key1: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1) { renderer.toImageProvider(size, content) }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1, key2) { renderer.toImageProvider(size, content) }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1, key2, key3) { renderer.toImageProvider(size, content) }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    vararg keys: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content, *keys) { renderer.toImageProvider(size, content) }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content) { ClusterImageProvider(size, renderer, content) }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1) { ClusterImageProvider(size, renderer, content) }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1, key2) { ClusterImageProvider(size, renderer, content) }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1, key2, key3) { ClusterImageProvider(size, renderer, content) }
}

/**
 * Highly experimental API. Will be changed in the future release
 * @param size use to render image on ios, ignored on android
 * @param content composable rendered to bitmap. Don't use animations or dynamic content.
 * Can be rendered only if key changed or parent render
 */
@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    vararg keys: Any?,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    val renderer = rememberComposeMapObjectRenderer()
    return remember(size, content, *keys) { ClusterImageProvider(size, renderer, content) }
}

public actual class ClusterImageProvider(
    private val size: DpSize,
    private val renderer: ComposeMapObjectRenderer,
    private val content: @Composable (Cluster) -> Unit,
) {
    @YandexMapsComposeExperimentalApi
    public actual fun toImageProvider(cluster: Cluster): ImageProvider {
        return renderer.toImageProvider(size) { content(cluster) }
    }
}