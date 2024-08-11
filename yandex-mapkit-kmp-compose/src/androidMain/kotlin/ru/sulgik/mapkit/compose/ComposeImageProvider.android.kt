package ru.sulgik.mapkit.compose

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.DpSize
import ru.sulgik.mapkit.geometry.Cluster
import ru.sulgik.mapkit.map.ImageProvider
import ru.sulgik.mapkit.map.toImageProvider

@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    content: @Composable () -> Unit
): ImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(size, content) {
        composeMapObjectRenderer.toImageProvider(
            size = size,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    key1: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1) {
        composeMapObjectRenderer.toImageProvider(
            size = size,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1, key2) {
        composeMapObjectRenderer.toImageProvider(
            size = size,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(size, content, key1, key2, key3) {
        composeMapObjectRenderer.toImageProvider(
            size = size,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun imageProvider(
    size: DpSize,
    vararg keys: Any?,
    content: @Composable () -> Unit
): ImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(size, content, *keys) {
        composeMapObjectRenderer.toImageProvider(
            size = size,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    content: @Composable (Cluster) -> Unit
): ClusterImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember {
        ClusterImageProvider(
            size = size,
            renderer = composeMapObjectRenderer,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    content: @Composable (Cluster) -> Unit,
): ClusterImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(key1 = key1) {
        ClusterImageProvider(
            size = size,
            renderer = composeMapObjectRenderer,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    content: @Composable (Cluster) -> Unit,
): ClusterImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(
        key1 = key1,
        key2 = key2
    ) {
        ClusterImageProvider(
            size = size,
            renderer = composeMapObjectRenderer,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    key1: Any?,
    key2: Any?,
    key3: Any?,
    content: @Composable (Cluster) -> Unit,
): ClusterImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(key1 = key1, key2 = key2, key3 = key3) {
        ClusterImageProvider(
            size = size,
            renderer = composeMapObjectRenderer,
            content = content
        )
    }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun clusterImageProvider(
    size: DpSize,
    vararg keys: Any?,
    content: @Composable (Cluster) -> Unit,
): ClusterImageProvider {
    val composeMapObjectRenderer = rememberComposeMapObjectRenderer()
    return remember(keys = keys) { ClusterImageProvider(size, composeMapObjectRenderer, content) }
}

@YandexMapsComposeExperimentalApi
@Composable
public actual fun rememberComposeMapObjectRenderer(): ComposeMapObjectRenderer {
    val parentView = ensureContainerView()
    val parentCompositionContext = rememberCompositionContext()
    return remember {
        ComposeMapObjectRenderer(
            parentView = parentView,
            parentCompositionContext = parentCompositionContext,
        )
    }
}


@YandexMapsComposeExperimentalApi
public actual class ClusterImageProvider internal constructor(
    private val size: DpSize,
    private val renderer: ComposeMapObjectRenderer,
    private val content: @Composable (Cluster) -> Unit
) {

    @YandexMapsComposeExperimentalApi
    internal actual fun toImageProvider(cluster: Cluster): ImageProvider {
        return renderer.toImageProvider(size) { content(cluster) }
    }
}

@YandexMapsComposeExperimentalApi
public actual class ComposeMapObjectRenderer internal constructor(
    private val parentView: ViewGroup,
    private val parentCompositionContext: CompositionContext,
) {

    @YandexMapsComposeExperimentalApi
    internal actual fun toImageProvider(
        size: DpSize,
        content: @Composable () -> Unit
    ): ImageProvider {
        return renderComposableToImageProvider(
            parent = parentView,
            compositionContext = parentCompositionContext,
            content = content,
        )
    }

}

private val measureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)

private fun renderComposableToImageProvider(
    parent: ViewGroup,
    compositionContext: CompositionContext,
    content: @Composable () -> Unit,
): ImageProvider {
    val fakeCanvas = Canvas()
    val composeView =
        ComposeView(parent.context)
            .apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                )
                setParentCompositionContext(compositionContext)
                setContent(content)
            }
            .also(parent::addView)

    composeView.draw(fakeCanvas)

    composeView.measure(measureSpec, measureSpec)

    if (composeView.measuredWidth == 0 || composeView.measuredHeight == 0) {
        throw IllegalStateException(
            "The ComposeView was measured to have a width or height of " +
                    "zero. Make sure that the content has a non-zero size."
        )
    }

    composeView.layout(0, 0, composeView.measuredWidth, composeView.measuredHeight)

    val bitmap =
        Bitmap
            .createBitmap(
                composeView.measuredWidth,
                composeView.measuredHeight,
                Bitmap.Config.ARGB_8888,
            )

    Canvas(bitmap).apply {
        composeView.draw(this)
    }

    parent.removeView(composeView)

    return bitmap.toImageProvider()
}

/**
 * Retrieves the [NoDrawContainerView] or adds one if there isn't already one.
 * @see NoDrawContainerView
 */
@Composable
private fun ensureContainerView(): NoDrawContainerView {
    val view = LocalView.current as ViewGroup
    val context = LocalContext.current
    return view.findViewById(R.id.maps_compose_nodraw_container_view)
        ?: NoDrawContainerView(context)
            .apply { id = R.id.maps_compose_nodraw_container_view }
            .also(view::addView)
}

/**
 * A ViewGroup that prevents its children from being laid out or drawn.
 * Used for adding ComposeViews as descendants of a MapView without actually affecting the view
 * hierarchy from the user's perspective.
 */
private class NoDrawContainerView(context: Context) : ViewGroup(context) {

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }

    override fun dispatchDraw(canvas: Canvas) {
    }

}