package ru.sulgik.mapkit.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.layer.GraphicsLayer
import androidx.compose.ui.graphics.layer.drawLayer
import androidx.compose.ui.graphics.rememberGraphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.toSize
import kotlinx.coroutines.channels.Channel
import ru.sulgik.mapkit.map.ImageProvider

/**
 * Renders composable content into [ImageProvider] to use it as map object icon.
 *
 * Content is composed in the hosting compose-ui composition, so it inherits theme, density and
 * other composition locals, and is re-rendered when its state changes.
 *
 * Renderer requires host in compose-ui composition. [YandexMap] hosts it for its own content,
 * to render content outside of map use [ComposeMapObjectRendererHost].
 */
@YandexMapsComposeExperimentalApi
@Composable
public fun rememberComposeMapObjectRenderer(): ComposeMapObjectRenderer {
    return remember { ComposeMapObjectRenderer() }
}

/**
 * Holds composable content to be rendered into [ImageProvider] by [ComposeMapObjectRendererHost].
 */
@YandexMapsComposeExperimentalApi
@Stable
public class ComposeMapObjectRenderer internal constructor() {

    internal val slots: SnapshotStateList<ComposeMapObjectSlot> = mutableStateListOf()

    internal fun attach(slot: ComposeMapObjectSlot) {
        slots.add(slot)
    }

    internal fun detach(slot: ComposeMapObjectSlot) {
        slots.remove(slot)
    }
}

/**
 * Provides [renderer] to [content] and renders content passed to [imageProvider] and
 * [clusterImageProvider] inside it.
 *
 * Required only to create image providers outside of [YandexMap] content.
 */
@YandexMapsComposeExperimentalApi
@Composable
public fun ComposeMapObjectRendererHost(
    renderer: ComposeMapObjectRenderer = rememberComposeMapObjectRenderer(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalComposeMapObjectRenderer provides renderer) {
        content()
        ComposeMapObjectSlots(renderer)
    }
}

@Stable
internal class ComposeMapObjectSlot(content: @Composable () -> Unit) {

    var content: @Composable () -> Unit by mutableStateOf(content)

    var image: ImageProvider? by mutableStateOf(null)
        private set

    var onImage: ((ImageProvider) -> Unit)? = null

    fun updateImage(image: ImageProvider) {
        this.image = image
        onImage?.invoke(image)
    }
}

@OptIn(YandexMapsComposeExperimentalApi::class)
internal val LocalComposeMapObjectRenderer: ProvidableCompositionLocal<ComposeMapObjectRenderer?> =
    staticCompositionLocalOf { null }

@OptIn(YandexMapsComposeExperimentalApi::class)
@Composable
internal fun requireComposeMapObjectRenderer(): ComposeMapObjectRenderer {
    return LocalComposeMapObjectRenderer.current ?: error(
        "No ComposeMapObjectRenderer provided. Composable content can be rendered only inside " +
            "YandexMap content or inside ComposeMapObjectRendererHost",
    )
}

@OptIn(YandexMapsComposeExperimentalApi::class)
@Composable
internal fun ComposeMapObjectSlots(renderer: ComposeMapObjectRenderer) {
    renderer.slots.toList().forEach { slot ->
        key(slot) {
            ComposeMapObjectSlotContent(slot)
        }
    }
}

@Composable
private fun ComposeMapObjectSlotContent(slot: ComposeMapObjectSlot) {
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current
    val layer = rememberGraphicsLayer()
    val records = remember(layer) { Channel<Unit>(Channel.CONFLATED) }
    Layout(
        content = {
            Box(
                modifier = Modifier.drawWithContent {
                    layer.record { this@drawWithContent.drawContent() }
                    records.trySend(Unit)
                },
            ) {
                slot.content()
            }
        },
        measurePolicy = DetachedContentMeasurePolicy,
    )
    LaunchedEffect(slot, layer, density, layoutDirection) {
        for (record in records) {
            val size = layer.size
            if (size.width <= 0 || size.height <= 0) continue
            val image = layer.drawToImageBitmap(density, layoutDirection)
            slot.updateImage(image.toImageProvider(density))
        }
    }
}

private fun GraphicsLayer.drawToImageBitmap(
    density: Density,
    layoutDirection: LayoutDirection,
): ImageBitmap {
    val image = ImageBitmap(size.width, size.height)
    CanvasDrawScope().draw(density, layoutDirection, Canvas(image), size.toSize()) {
        drawLayer(this@drawToImageBitmap)
    }
    return image
}

private val DetachedContentMeasurePolicy = MeasurePolicy { measurables, _ ->
    val placeables = measurables.map { it.measure(Constraints()) }
    layout(MinDrawableSize, MinDrawableSize) {
        placeables.forEach { it.place(0, 0) }
    }
}

private const val MinDrawableSize = 1
