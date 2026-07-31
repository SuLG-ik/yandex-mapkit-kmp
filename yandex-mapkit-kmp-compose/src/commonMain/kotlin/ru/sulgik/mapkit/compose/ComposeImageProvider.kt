package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.map.IconStyle
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.PlacemarkMapObject

/**
 * Renders [content] into [ImageProvider] to use it as map object icon.
 *
 * Size of the result image is the size of the content measured without constraints, so content
 * should have intrinsic size. Content is composed in compose-ui composition, inherits composition
 * locals of the caller and is re-rendered on every content state change.
 *
 * Returns `null` until content is rendered for the first time.
 *
 * Content stays composed while the caller is composed, so avoid infinite animations in it and
 * prefer sharing one image provider between map objects with the same content.
 *
 * Requires [ComposeMapObjectRendererHost] in compose-ui composition, [YandexMap] provides it for
 * its own content.
 */
@YandexMapsComposeExperimentalApi
@Composable
public fun imageProvider(content: @Composable () -> Unit): ImageProvider? {
    val renderer = requireComposeMapObjectRenderer()
    val slot = remember(renderer) { ComposeMapObjectSlot(content) }
    SideEffect { slot.content = content }
    DisposableEffect(renderer, slot) {
        renderer.attach(slot)
        onDispose { renderer.detach(slot) }
    }
    return slot.image
}

/**
 * Cluster data available to render cluster icon.
 *
 * Used as a key of rendered images cache, so clusters with the same data share one image.
 */
@Immutable
public data class ClusterInfo(
    val size: Int,
)

/**
 * Renders [content] into [ImageProvider] for every distinct [ClusterInfo] to use it as cluster
 * icon.
 *
 * Rendered images are cached by [ClusterInfo], so content is rendered once per distinct cluster
 * data and is reused by all clusters with the same data. Content is re-rendered on every content
 * state change.
 *
 * Requires [ComposeMapObjectRendererHost] in compose-ui composition, [YandexMap] provides it for
 * its own content.
 */
@YandexMapsComposeExperimentalApi
@Composable
public fun clusterImageProvider(content: @Composable (ClusterInfo) -> Unit): ClusterImageProvider {
    val renderer = requireComposeMapObjectRenderer()
    val provider = remember(renderer) { ClusterImageProvider(renderer, content) }
    SideEffect { provider.content = content }
    DisposableEffect(provider) {
        onDispose { provider.dispose() }
    }
    return provider
}

/**
 * Provides cluster icons rendered from composable content.
 *
 * @see clusterImageProvider
 */
@YandexMapsComposeExperimentalApi
@Stable
public class ClusterImageProvider internal constructor(
    private val renderer: ComposeMapObjectRenderer,
    content: @Composable (ClusterInfo) -> Unit,
) {

    private val slots = mutableMapOf<ClusterInfo, ComposeMapObjectSlot>()

    private val images = mutableMapOf<ClusterInfo, ImageProvider>()

    private val clusters = mutableMapOf<ClusterInfo, MutableList<RenderedCluster>>()

    internal var content: @Composable (ClusterInfo) -> Unit = content
        set(value) {
            if (field == value) return
            field = value
            slots.forEach { (info, slot) -> slot.content = { value(info) } }
        }

    internal fun setIcon(cluster: Cluster, style: IconStyle) {
        val info = ClusterInfo(size = cluster.size)
        val appearance = cluster.appearance
        val rendered = clusters.getOrPut(info) { mutableListOf() }
        rendered.removeAll { !it.appearance.isValid }
        rendered.add(RenderedCluster(appearance = appearance, style = style))
        val image = images[info]
        if (image != null) {
            appearance.setIcon(image, style)
            return
        }
        appearance.setIcon(EmptyImage, style)
        if (info in slots) return
        val slot = ComposeMapObjectSlot { content(info) }
        slot.onImage = { image -> onImageRendered(info, image) }
        slots[info] = slot
        renderer.attach(slot)
    }

    internal fun dispose() {
        slots.values.forEach(renderer::detach)
        slots.clear()
        images.clear()
        clusters.clear()
    }

    private fun onImageRendered(info: ClusterInfo, image: ImageProvider) {
        images[info] = image
        val rendered = clusters[info] ?: return
        rendered.removeAll { !it.appearance.isValid }
        rendered.forEach { it.appearance.setIcon(image, it.style) }
    }

    private class RenderedCluster(
        val appearance: PlacemarkMapObject,
        val style: IconStyle,
    )

    private companion object {
        private val EmptyImage: ImageProvider by lazy { ImageBitmap(1, 1).toImageProvider() }
    }

}
